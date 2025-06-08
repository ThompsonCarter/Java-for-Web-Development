@Entity
public class Task {
  @Id @GeneratedValue
  private Long id;
  @NotBlank
  private String description;
  private boolean completed = false;
  // getters, setters
}