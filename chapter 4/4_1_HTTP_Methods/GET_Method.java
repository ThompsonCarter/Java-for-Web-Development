
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final List<Product> products = new CopyOnWriteArrayList<>();

    @GetMapping
    public List<Product> getAll() {
        return products;
    }
}
