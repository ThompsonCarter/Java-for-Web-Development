try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
  executor.submit(() -> System.out.println("Running in a virtual thread"));
}