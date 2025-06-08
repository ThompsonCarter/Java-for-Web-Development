
    // Code for Measure First, Fix Later section
    // Example code for enabling JFR and measuring CPU usage
    java -XX:StartFlightRecording=duration=30s,filename=app.jfr -jar taskmanager.jar
    