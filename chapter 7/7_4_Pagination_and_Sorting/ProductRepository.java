import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Page<Product> findByCategoryId(Long categoryId, Pageable pageable);
}