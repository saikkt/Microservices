package com.reactive.reactiveservice.service;

import com.reactive.reactiveservice.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getCustomer(long id);

    List<Customer> getAll();
}
