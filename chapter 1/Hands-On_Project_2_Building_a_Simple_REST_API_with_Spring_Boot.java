
// Spring Boot example for API
@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue="World") String name) {
        return "Hello, " + name + "!";
    }
}