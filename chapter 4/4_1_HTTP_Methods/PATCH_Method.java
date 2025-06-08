
@PatchMapping("/{id}")
public Product update(@PathVariable int id, @RequestBody Map<String, Object> changes) {
    Product existing = products.get(id);
    if (changes.containsKey("price")) {
        existing.setPrice(((Number)changes.get("price")).doubleValue());
    }
    return existing;
}
