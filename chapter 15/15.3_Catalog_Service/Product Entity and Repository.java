@Entity
@Table(name = "products")
public class Product {
  @Id @GeneratedValue private Long id;
  @NotBlank private String name;
  private String description;
  private BigDecimal price;
  private String imageUrl;
}

public interface ProductRepository
    extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> { }
