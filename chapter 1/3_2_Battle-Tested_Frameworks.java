
// Example code for Spring Boot setup
@RestController
@RequestMapping("/api")
public class HelloController {

  @GetMapping("/hello")
  public String sayHello(@RequestParam(defaultValue="World") String name) {
    return "Hello, " + name + "!";
  }
}