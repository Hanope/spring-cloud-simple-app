package com.hope.delivery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

  @Value("${server.port}")
  private int port;

  @GetMapping("/{deliveryId}")
  public String getDeliveryInfo(@PathVariable String deliveryId) {
    return "delivery port number: " + port +
        "\n[product Delivery Id: " + deliveryId + "]";
  }
}
