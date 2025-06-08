@Service
public class OrderService {
  @Autowired private ProductRepository productRepo;
  @Autowired private OrderRepository orderRepo;

  @Transactional
  public Order placeOrder(Long productId, int qty) {
    Product p = productRepo.findById(productId)
      .orElseThrow(() -> new RuntimeException("Not found"));
    if (p.getQuantity() < qty) {
      throw new RuntimeException("Insufficient stock");
    }
    p.setQuantity(p.getQuantity() - qty);
    productRepo.save(p);

    Order order = new Order(p, qty);
    return orderRepo.save(order);
  }
}