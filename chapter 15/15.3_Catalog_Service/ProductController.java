@RestController
@RequestMapping("/products")
@CacheConfig(cacheNames = "products")
@RequiredArgsConstructor
class ProductController {

  private final ProductRepository repo;

  @Cacheable
  @GetMapping("/{id}")
  Product one(@PathVariable Long id) {
    return repo.findById(id).orElseThrow(() -> new NotFoundException(id));
  }

  @GetMapping
  Page<Product> list(Pageable pageable,
                     @RequestParam Optional<String> q) {
    Specification<Product> spec = q
        .<Specification<Product>>map(txt ->
            (root, _, cb) ->
              cb.like(cb.lower(root.get("name")), "%" + txt.toLowerCase() + "%"))
        .orElse(null);
    return repo.findAll(spec, pageable);
  }
}
