package com.hope.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/displays")
public class DisplayController {

  @Value("${server.port}")
  private int port;

  @Autowired
  private FeignProductService feignProductService;

  @Autowired
  private FeignDeliveryService feignDeliveryService;

  @GetMapping("/{productId}")
  public String getDisplayInfo(@PathVariable String productId) {
    String productInfo = feignProductService.getProductInfo(productId);
    String deliveryInfo = feignDeliveryService.getDeliveryInfo(productId);

    return "display port number: " + port +
        "\n\n------- productInfo -------\n" + productInfo +
        "\n\n------- deliveryInfo -------\n" + deliveryInfo;
  }

}
