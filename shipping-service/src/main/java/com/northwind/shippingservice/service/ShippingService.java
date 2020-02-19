package com.northwind.shippingservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.northwind.shippingservice.domain.ShippingEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShippingService {
    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper;
    private Map<String,Object> data = new HashMap<>();

    public ShippingService(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper =  new ObjectMapper();
    }

    public void sendOrderShippedNotification(long orderId) throws JsonProcessingException {
        ShippingEvent shippingEvent = new ShippingEvent();
        shippingEvent.setEventType("Order-Shipped-Notification");
        data.put("OrderId",orderId);
        data.put("ShippedDate", Calendar.getInstance().getTime());
        shippingEvent.setEventData(data);
        rabbitTemplate.convertAndSend("shipping-service-events","",objectMapper.writeValueAsString(shippingEvent));
    }
}
