@GetMapping("/categories/{id}/products")
public Page<Product> listByCategory(@PathVariable Long id, 
                                    @RequestParam(defaultValue = "0") int page, 
                                    @RequestParam(defaultValue = "10") int size) {
  return productService.getProductsByCategory(id, page, size);
}