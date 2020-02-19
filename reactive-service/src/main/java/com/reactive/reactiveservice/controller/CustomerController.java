package com.reactive.reactiveservice.controller;

import com.reactive.reactiveservice.model.Customer;
import com.reactive.reactiveservice.service.CustomerService;
import com.reactive.reactiveservice.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") final String id){
        return customerService.getCustomer(Long.parseLong(id));
    }
}
