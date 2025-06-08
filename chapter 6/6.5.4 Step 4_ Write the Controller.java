@RestController
@RequestMapping("/api/tasks")
public class TaskController {
  private final TaskService service;

  @Autowired
  public TaskController(TaskService service) { this.service = service; }

  @GetMapping
  public List<Task> list() { return service.listAll(); }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Task create(@Valid @RequestBody Task t) { return service.create(t); }

  @PutMapping("/{id}")
  public Task update(@PathVariable Long id, @Valid @RequestBody Task t) {
    return service.update(id, t);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) { service.delete(id); }
}