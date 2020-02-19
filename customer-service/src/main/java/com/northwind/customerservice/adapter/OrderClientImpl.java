package com.northwind.customerservice.adapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class OrderClientImpl implements OrderClient {
    private RestTemplate restTemplate;
    private OrderConfig orderConfig;

    public OrderClientImpl(RestTemplate restTemplate, OrderConfig orderConfig) {
        this.restTemplate = restTemplate;
        this.orderConfig = orderConfig;
    }

    @Override
    public List<OrderModel> getCustomerOrders(String customerNo) {
        ResponseEntity<OrderModel[]> orderModelResponseEntity = restTemplate.getForEntity(orderConfig.getURL()+"/orders/orderhistory/"+customerNo,OrderModel[].class);
        OrderModel[] orderModels = orderModelResponseEntity.getBody();
        return Arrays.asList(orderModels);
    }
}
