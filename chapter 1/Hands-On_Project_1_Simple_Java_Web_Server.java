
import java.net.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var server = new ServerSocket(8080);
    System.out.println("Listening on port 8080...");
    while (true) {
      var client = server.accept();
      new Thread(() -> handle(client)).start();
    }
  }

  private static void handle(Socket client) {
    try (var in = new BufferedReader(new InputStreamReader(client.getInputStream()));
         var out = new PrintWriter(client.getOutputStream())) {
      String line = in.readLine();
      System.out.println("Received: " + line);
      out.print("HTTP/1.1 200 OK
");
      out.print("Content-Type: text/plain

");
      out.print("Hello from raw Java!
");
      out.flush();
      client.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}