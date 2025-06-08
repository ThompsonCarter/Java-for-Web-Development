
    // Code for App Metrics with Micrometer section
    // Example Micrometer integration with Spring Boot
    @Service
    public class CheckoutService {
        private final Counter purchases = Metrics.counter("checkout.count");

        public void buy(Item i) {
            purchases.increment();
            // ...
        }
    }
    