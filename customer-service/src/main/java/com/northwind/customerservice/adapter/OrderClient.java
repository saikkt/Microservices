package com.northwind.customerservice.adapter;

import java.util.List;

public interface OrderClient {
    List<OrderModel> getCustomerOrders(String customerNo);
}
