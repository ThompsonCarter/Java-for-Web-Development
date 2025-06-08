
Start Config Server, then Eureka, then each service.

Use curl or Postman to create a user, then tasks—for each operation watch logs: Eureka registration, config fetch, circuit breaker health.

Shutdown Task service and attempt a task creation to see circuit breaker open.
