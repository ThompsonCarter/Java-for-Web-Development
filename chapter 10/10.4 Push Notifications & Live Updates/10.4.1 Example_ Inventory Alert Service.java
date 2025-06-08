@Service
public class InventoryService {
  @Autowired
  private SimpMessagingTemplate template;

  @Scheduled(fixedRate = 5000)
  public void checkInventory() {
    List<Product> lowStock = productRepo.findByQuantityLessThan(5);
    lowStock.forEach(p ->
      template.convertAndSend("/topic/alerts", 
        Map.of("product", p.getName(), "qty", p.getQuantity())));
  }
}