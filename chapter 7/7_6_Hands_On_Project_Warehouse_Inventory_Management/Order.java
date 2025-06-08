@Entity
public class Order {
  @Id @GeneratedValue private Long id;
  private LocalDateTime placedAt = LocalDateTime.now();
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  private List<OrderItem> items = new ArrayList<>();
  // getters/setters
}