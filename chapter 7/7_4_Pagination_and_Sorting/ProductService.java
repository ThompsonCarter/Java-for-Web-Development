public Page<Product> getProductsByCategory(Long categoryId, int page, int size) {
  Pageable p = PageRequest.of(page, size, Sort.by("name").ascending());
  return productRepo.findByCategoryId(categoryId, p);
}