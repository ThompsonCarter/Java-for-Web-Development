
pipeline {
  agent { docker { image 'maven:3-eclipse-temurin-17' } }
  stages {
    stage('Checkout') { steps { checkout scm } }
    stage('Test')     { steps { sh 'mvn -B verify' } }
    stage('Package')  { steps { sh 'docker build -t app:$BUILD_TAG .' } }
    stage('Push')     { steps { withCredentials([usernamePassword(...)]) {
                                 sh 'docker push app:$BUILD_TAG' }} }
    stage('Deploy')   { when { branch 'main' }
                        steps { sh 'helm upgrade --install app chart/ --set image.tag=$BUILD_TAG' } }
  }
  post { always { junit 'target/surefire-reports/*.xml'
                  jacoco execPattern: 'target/jacoco.exec' } }
}
    