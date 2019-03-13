package com.hope.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Value("${server.port}")
  private int port;

  @GetMapping("/{productId}")
  public String getProductById(@PathVariable String productId) {
    return "product port number: " + port +
        "\n[productId: " + productId + "]";
  }
}
