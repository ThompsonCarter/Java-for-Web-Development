
@Service
public class NotificationClient {
  private final RestTemplate rest;
  private final CircuitBreaker cb;

  public NotificationClient(RestTemplateBuilder b, CircuitBreakerRegistry reg) {
    this.rest = b.build();
    this.cb = reg.circuitBreaker("taskService");
  }

  public void notifyTaskCreation(Task t) {
    Supplier<Void> supplier = CircuitBreaker.decorateSupplier(cb, () -> {
      rest.postForEntity("http://TASK-SERVICE/tasks", t, Void.class);
      return null;
    });
    Try.ofSupplier(supplier)
       .onFailure(ex -> log.error("Notification failed", ex));
  }
}
