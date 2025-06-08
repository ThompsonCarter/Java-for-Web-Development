@RequiredArgsConstructor
@Service
public class OrderService {
  private final OrderRepository repo;
  private final KafkaTemplate<String, OrderEvent> kafka;

  @Transactional
  public Order create(String sessionId, Map<Long,Integer> lines) {
    Order o = repo.save(Order.of(sessionId, lines));
    kafka.send("order-events", new OrderEvent(o.getId(), "CREATED"));
    return o;
  }
}
