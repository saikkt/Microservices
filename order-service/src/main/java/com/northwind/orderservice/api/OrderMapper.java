package com.northwind.orderservice.api;

import com.northwind.orderservice.domain.Order;

import java.sql.Date;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderModel toModel(Order entity) {
        OrderModel model = new OrderModel();
        model.setOrderNo(entity.getId());
        model.setCustomerId(entity.getCustomerId());
        model.setCustomerNo(entity.getCustomerNo());
        model.setCompanyName(entity.getCompanyName());
        model.setOrderDate(entity.getOrderDate());
        model.setTotal(entity.getOrderTotal());
        model.setVersion(entity.getVersion());
        model.setShipAddress(entity.getShipAddress());
        model.setShipCity(entity.getShipCity());
        model.setShipCountry(entity.getShipCountry());
        model.setShipPostalCode(entity.getShipPostalCode());
        model.setShipRegion(entity.getShipRegion());
        model.setShipName(entity.getShipName());
        model.setStatus(entity.getStatus());
        model.setShippedDate(entity.getShippedDate());
        model.setItems(entity.getItems().stream().map(o->OrderItemMapper.toModel(o)).collect(Collectors.toList()));
        return model;
    }

    public static Order toNewEntity(OrderModel model) {
        Order entity = new Order(model.getCustomerId(),
                                 model.getCustomerNo(),
                                 model.getCompanyName());

        entity.setOrderDate(new Date(model.getOrderDate().getTime()));
        entity.setShipAddress(model.getShipAddress());
        entity.setShipCity(model.getShipCity());
        entity.setShipCountry(model.getShipCountry());
        entity.setShipPostalCode(model.getShipPostalCode());
        entity.setShipRegion(model.getShipRegion());
        entity.setShipName(model.getShipName());

        model.getItems().stream().forEach(i->entity.addItem(OrderItemMapper.newEntity(entity, i)));
        return entity;
    }

    public static void merge(OrderModel model, Order entity) {
        entity.setShipAddress(model.getShipAddress());
        entity.setShipCity(model.getShipCity());
        entity.setShipCountry(model.getShipCountry());
        entity.setShipPostalCode(model.getShipPostalCode());
        entity.setShipRegion(model.getShipRegion());
        entity.setShipName(model.getShipName());
    }
}
