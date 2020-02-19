package com.reactive.reactiveservice.client;

import com.reactive.reactiveservice.model.Customer;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface CustomerClient {
    Single<Customer> find(final long id);

    Observable<Long> getCustomerIds();
}
