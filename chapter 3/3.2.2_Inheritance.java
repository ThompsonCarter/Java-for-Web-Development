public class User {
  String username;
  public User(String u) { username = u; }
  public String info() { return "User: " + username; }
}

public class Admin extends User {
  public Admin(String u) { super(u); }
  public String info() {
    return super.info() + " (admin)";
  }
}