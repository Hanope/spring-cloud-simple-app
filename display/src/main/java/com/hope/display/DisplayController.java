package com.hope.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/displays")
public class DisplayController {

  @Autowired
  private RestTemplate restTemplate;

  private static final String PRODUCT_URL = "http://localhost:8081/products/";

  private static final String DELIVERY_URL = "http://localhost:7081/deliveries/";

  @Value("${server.port}")
  private int port;

  @GetMapping("/{productId}")
  public String getDisplayInfo(@PathVariable String productId) {
    String productInfo = restTemplate.getForObject(PRODUCT_URL + productId, String.class);
    String deliveryInfo = restTemplate.getForObject(DELIVERY_URL + productId, String.class);

    return "display port number: " + port +
        "\n\n------- productInfo -------\n" + productInfo +
        "\n\n------- deliveryInfo -------\n" + deliveryInfo;
  }

}
