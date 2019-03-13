package com.hope.display;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "delivery")
public interface FeignDeliveryService {

  @RequestMapping("/deliveries/{productId}")
  String getDeliveryInfo(@PathVariable String productId);

}
