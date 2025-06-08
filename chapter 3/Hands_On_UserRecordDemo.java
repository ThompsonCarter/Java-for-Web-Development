public class UserRecordDemo {
  public static void main(String[] args) {
    record Product(String name, double price) {}
    var p = new Product("Widget", 49.99);
    System.out.println(p);
  }
}