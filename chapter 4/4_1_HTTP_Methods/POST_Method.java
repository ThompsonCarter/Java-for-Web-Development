
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public Product create(@RequestBody Product p) {
    products.add(p);
    return p;
}
