
@GetMapping("/{id}")
public ResponseEntity<Product> getOne(@PathVariable int id) {
    if (id < 0 || id >= products.size()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(products.get(id));
}
