@Entity
public class OrderItem {
  @Id @GeneratedValue private Long id;
  @ManyToOne private Order order;
  @ManyToOne private Product product;
  private Integer quantity;
  // getters/setters
}