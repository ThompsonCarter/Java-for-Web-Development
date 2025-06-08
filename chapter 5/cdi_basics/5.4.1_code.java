
// CDI Basics example
@ApplicationScoped
public class GreetingService {
  public String greet(String name) {
    return "Hello, " + name + "! Welcome to CDI.";
  }
}
