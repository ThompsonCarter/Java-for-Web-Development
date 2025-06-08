
New app task-service.

Relies on user-service to validate user existence via Eureka + RestTemplate + CircuitBreaker.

Expose POST /tasks, GET /tasks/user/{userId}.
