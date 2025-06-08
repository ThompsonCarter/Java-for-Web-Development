import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class WebDemo {
  public static void main(String[] args) throws Exception {
    var server = new ServerSocket(8080);
    System.out.println("Server listening on 8080");
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      while (true) {
        Socket client = server.accept();
        executor.submit(() -> handle(client));
      }
    }
  }

  private static void handle(Socket client) {
    record Status(String message, int code) {}
    try (var in = new BufferedReader(new InputStreamReader(client.getInputStream()));
         var out = new PrintWriter(client.getOutputStream())) {
      in.readLine(); // skip request
      Status ok = new Status("OK", 200);
      out.print("HTTP/1.1 200 " + ok.message + "
");
      out.print("Content-Type: text/plain

");
      out.print("Status code: " + ok.code + "
");
      out.flush();
      client.close();
    } catch (IOException e) { e.printStackTrace(); }
  }
}