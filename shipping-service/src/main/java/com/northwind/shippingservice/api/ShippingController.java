package com.northwind.shippingservice.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.northwind.shippingservice.service.ShippingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sendOrderShippedNotification")
public class ShippingController {

    private ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping
    public ResponseEntity get(@RequestParam long orderId) throws JsonProcessingException {
        shippingService.sendOrderShippedNotification(orderId);

        return ResponseEntity.ok().build();
    }
}
