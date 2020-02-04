package com.northwind.shippingservice.services;

import com.northwind.shippingservice.domain.ShippingRates;
import com.northwind.shippingservice.repositories.ShippingRatesRepository;

import java.util.List;

public class ShippingRatesService {

    private ShippingRatesRepository shippingRatesRepository;

    public ShippingRatesService(ShippingRatesRepository shippingRatesRepository)
    {
        this.shippingRatesRepository = shippingRatesRepository;
    }

    public ShippingRates getById(long id){
        return shippingRatesRepository.getById(id);
    }

    public List<ShippingRates> getByCountry(String country){
        return shippingRatesRepository.getByCountry(country);
    }

    public List<ShippingRates> getAll(int offset, int limit){
        return shippingRatesRepository.getAll(offset, limit);
    }

    public void delete(ShippingRates shippingRates){
         shippingRatesRepository.delete(shippingRates.getId());
    }

    public ShippingRates save(ShippingRates shippingRates){
        ShippingRates savedRate = shippingRatesRepository.save(shippingRates);

        return savedRate;

    }
}
