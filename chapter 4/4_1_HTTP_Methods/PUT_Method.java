
@PutMapping("/{id}")
public Product replace(@PathVariable int id, @RequestBody Product p) {
    products.set(id, p);
    return p;
}
