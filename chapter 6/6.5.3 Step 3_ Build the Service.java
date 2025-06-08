@Service
public class TaskService {
  private final TaskRepository repo;

  @Autowired
  public TaskService(TaskRepository repo) { this.repo = repo; }

  public List<Task> listAll() { return repo.findAll(); }
  public Task create(Task t) { return repo.save(t); }
  public Task update(Long id, Task t) {
    return repo.findById(id)
      .map(existing -> {
        existing.setDescription(t.getDescription());
        existing.setCompleted(t.isCompleted());
        return repo.save(existing);
      }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
  public void delete(Long id) { repo.deleteById(id); }
}