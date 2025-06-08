@Service
public class TaskService {
  private final TaskRepository repo;

  @Autowired
  public TaskService(TaskRepository repo) { this.repo = repo; }

  public List<Task> listAll() { return repo.findAll(); }
  public Task create(Task t) { return repo.save(t); }
  public void delete(Long id) { repo.deleteById(id); }
}