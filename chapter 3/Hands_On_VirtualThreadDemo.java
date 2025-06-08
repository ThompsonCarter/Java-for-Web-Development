import java.util.concurrent.*;

public class VirtualThreadDemo {
  public static void main(String[] args) throws Exception {
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      for (int i = 1; i <= 10; i++) {
        int id = i;
        executor.submit(() -> {
          System.out.println("Task #" + id + " on " + Thread.currentThread());
        });
      }
    }
  }
}