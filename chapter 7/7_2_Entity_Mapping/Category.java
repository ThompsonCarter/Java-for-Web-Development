@Entity
@Table(name = "categories")
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
  private List<Product> products = new ArrayList<>();

  // Constructors, getters/setters...
}