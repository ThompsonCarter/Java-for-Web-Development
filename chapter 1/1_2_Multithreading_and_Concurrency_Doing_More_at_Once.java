
public class MultiThreadingExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("Thread 1 running"));
        Thread thread2 = new Thread(() -> System.out.println("Thread 2 running"));
        thread1.start();
        thread2.start();
    }
}