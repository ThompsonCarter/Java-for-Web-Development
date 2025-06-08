@Entity
public class Task {
  @Id @GeneratedValue
  private Long id;
  private String description;
  private boolean completed;
  // getters/setters
}