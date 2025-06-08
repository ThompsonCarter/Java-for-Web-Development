@Controller
public class DashboardController {
  @GetMapping("/dashboard")
  public String show(Model model, Principal principal) {
    model.addAttribute("user", userService.findByUsername(principal.getName()));
    model.addAttribute("tasks", taskService.listAll());
    return "dashboard";
  }
}