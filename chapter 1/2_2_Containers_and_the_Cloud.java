
// Dockerfile example
FROM eclipse-temurin:17-jdk-jammy
COPY target/myapp.jar /app/myapp.jar
ENTRYPOINT ["java","-jar","/app/myapp.jar"]