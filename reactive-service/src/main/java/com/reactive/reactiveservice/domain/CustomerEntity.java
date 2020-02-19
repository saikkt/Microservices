package com.reactive.reactiveservice.domain;

import com.reactive.reactiveservice.model.Customer;

public class CustomerEntity {

    private long id;
    private String firstName;
    private String lastName;

    public CustomerEntity(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer transform(){
        return new Customer(this.id,this.firstName,this.lastName);
    }
}
