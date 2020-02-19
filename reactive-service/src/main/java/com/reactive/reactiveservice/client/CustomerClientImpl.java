package com.reactive.reactiveservice.client;

import com.reactive.reactiveservice.model.Customer;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Component
public class CustomerClientImpl implements CustomerClient {

    private CustomerRepository customerRepository;

    public CustomerClientImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Single<Customer> find(long id) {
        return Single.create(singleSubscriber -> singleSubscriber.onSuccess(
                customerRepository.find(id).transform()
        ));
    }

    @Override
    public Observable<Long> getCustomerIds() {
        return Observable.unsafeCreate(subscriber->{
            customerRepository.findAll()
                    .stream()
                    .forEach(l->subscriber.onNext(l));
        }).zipWith(Observable.interval(1, TimeUnit.SECONDS),(id,l)->l);
    }

}
