import java.util.Random;

public class OrderProcessor {
  public static void main(String[] args) {
    int totalOrders = 5;
    Random rand = new Random();

    for (int i = 1; i <= totalOrders; i++) {
      double price = 10 + rand.nextDouble() * 90; // $10–$100
      System.out.printf("Order %d: $%.2f%n", i, price);
    }

    int retries = 3;
    while (retries > 0) {
      boolean success = rand.nextBoolean();
      System.out.println(success ? "Shipment succeeded!" : "Shipment failed.");
      if (success) break;
      retries--;
    }
  }
}