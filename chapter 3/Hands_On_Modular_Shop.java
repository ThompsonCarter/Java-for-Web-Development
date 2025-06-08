package com.example.shop.api;
public interface ShopService {
  String listProducts();
}

package com.example.shop.impl;
import com.example.shop.api.ShopService;
public class ShopServiceImpl implements ShopService {
  public String listProducts() {
    return "Apple, Banana, Carrot";
  }
}

module com.example.shop {
  exports com.example.shop.api;
}