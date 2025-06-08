
    // Code for Micro-Caching with Caffeine section
    // Caffeine cache implementation example
    Cache<Long, Task> taskCache = Caffeine.newBuilder()
    .expireAfterWrite(Duration.ofMinutes(5))
    .maximumSize(10_000)
    .recordStats()
    .build();
    