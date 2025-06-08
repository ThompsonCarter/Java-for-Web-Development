
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final List<Product> products = new CopyOnWriteArrayList<>();

    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable int id) {
        if (id < 0 || id >= products.size()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products.get(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@Valid @RequestBody Product p) {
        products.add(p);
        return p;
    }

    @PutMapping("/{id}")
    public Product replace(@PathVariable int id, @Valid @RequestBody Product p) {
        products.set(id, p);
        return p;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        products.remove(id);
    }
}
