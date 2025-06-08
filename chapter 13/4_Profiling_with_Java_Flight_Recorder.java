
    // Code for Profiling with Java Flight Recorder section
    // Sample command for capturing JFR profile
    java -XX:StartFlightRecording=duration=30s,filename=app.jfr -jar taskmanager.jar
    