package com.reactive.reactiveservice.client;

import com.reactive.reactiveservice.domain.CustomerEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository {

    private static final List<CustomerEntity> customerStore = new ArrayList<CustomerEntity>();

    static {
        customerStore.add(new CustomerEntity(1L, "Ivan", "Agathe"));
        customerStore.add(new CustomerEntity(2L, "Hana", "Godfrey"));
        customerStore.add(new CustomerEntity(3L, "Varghese", "Yaroslav"));
    }
        CustomerEntity find(final long id) throws Exception {
            return customerStore
                    .stream()
                    .filter(customer->customer.getId()==id)
                    .findFirst()
                    .orElseThrow(Exception::new);
        }

        List<Long> findAll(){
            return customerStore.stream().map(CustomerEntity::getId).collect(Collectors.toList());
        }
    }

