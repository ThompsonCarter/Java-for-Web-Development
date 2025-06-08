public class Product {
  private String name;
  private double price;

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String display() {
    return name + ": $" + price;
  }
}
Product p = new Product("Gadget", 29.99);
System.out.println(p.display());