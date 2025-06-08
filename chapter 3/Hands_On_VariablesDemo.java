public class VariablesDemo {
  public static void main(String[] args) {
    int userCount = 42;
    double serverLoad = 0.73;
    boolean maintenance = false;
    String status = maintenance ? "Down for maintenance" : "Online";

    System.out.println("Users: " + userCount);
    System.out.println("Load: " + serverLoad);
    System.out.println("Status: " + status);
  }
}