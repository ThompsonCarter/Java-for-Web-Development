
@GetMapping("/api/products")
public List<Product> getAll(@RequestHeader(value = HttpHeaders.ACCEPT, defaultValue = "application/json") String accept) {
    if (accept.equals("application/xml")) {
        // return XML representation
    }
    return products; // default JSON
}
