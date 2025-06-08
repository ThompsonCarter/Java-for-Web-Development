
@Testcontainers
@SpringBootTest
class OrderRepositoryIT {

  @Container
  static PostgreSQLContainer<?> db = new PostgreSQLContainer<>("postgres:16");

  @DynamicPropertySource
  static void props(DynamicPropertyRegistry r){
     r.add("spring.datasource.url", db::getJdbcUrl);
     r.add("spring.datasource.username", db::getUsername);
     r.add("spring.datasource.password", db::getPassword);
  }

  @Autowired OrderRepository repo;

  @Test void shouldPersist() {
     Order o = repo.save(new Order("A-123"));
     assertTrue(repo.findById(o.getId()).isPresent());
  }
}
    