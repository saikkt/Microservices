package com.reactive.reactiveservice.service;

import com.reactive.reactiveservice.client.CustomerClient;
import com.reactive.reactiveservice.model.Customer;
import io.reactivex.schedulers.Schedulers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class CustomerServiceImpl implements CustomerService  {
    private final CustomerClient customerClient;

    public CustomerServiceImpl(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    @Override
    public Customer getCustomer(final long id){
        return customerClient.find(id)
                .subscribeOn(Schedulers.io())
                .blockingGet();
    }

    @Override
    public List<Customer> getAll() {
        return customerClient.getCustomerIds()
                .flatMap(id-> {
                    return customerClient.find(id).toObservable();
                }).toList().blockingGet();
    }
}
