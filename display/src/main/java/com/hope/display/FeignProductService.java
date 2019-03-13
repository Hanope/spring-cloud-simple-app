package com.hope.display;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product")
public interface FeignProductService {

  @RequestMapping("/products/{productId}")
  String getProductInfo(@PathVariable String productId);

}
