
// Simple Spring Boot controller code
@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue="World") String name) {
        return "Hello, " + name + "!";
    }
}