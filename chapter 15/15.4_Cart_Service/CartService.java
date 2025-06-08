@Service
@RequiredArgsConstructor
public class CartService {
  private final StringRedisTemplate redis;

  public void add(String sessionId, Long productId, int qty) {
    BoundHashOperations<String,Object,Object> cart =
        redis.boundHashOps("cart:"+sessionId);
    cart.increment(productId.toString(), qty);
    cart.expire(Duration.ofDays(1));
  }

  public Map<Long,Integer> view(String sessionId) {
    return redis.<String,Integer>boundHashOps("cart:"+sessionId)
                .entries().entrySet().stream()
                .collect(toMap(e -> Long.valueOf(e.getKey()), Map.Entry::getValue));
  }
}
