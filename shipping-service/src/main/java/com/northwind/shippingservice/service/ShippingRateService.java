package com.northwind.shippingservice.service;

import com.northwind.shippingservice.domain.ShippingRate;
import com.northwind.shippingservice.repository.ShippingRateRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingRateService {
    private ShippingRateRepository shippingRateRepository;

    public ShippingRateService(ShippingRateRepository shippingRateRepository) {
        this.shippingRateRepository = shippingRateRepository;
    }

    public Optional<ShippingRate> getById(long shippingId){
        return shippingRateRepository.findById(shippingId);
    }

    public List<ShippingRate> getAllShippingRates(int page, int size ){
        return shippingRateRepository.findAll(PageRequest.of(page,size)).toList();
    }

    public List<ShippingRate> getByCountry(String country){
        return shippingRateRepository.getByCountry(country);
    }

    public ShippingRate save(ShippingRate shippingRate)
    {
        ShippingRate savedShippingRate = shippingRateRepository.saveAndFlush(shippingRate);
        return savedShippingRate;
    }

    public void delete(long shippingRateId){
        shippingRateRepository.deleteById(shippingRateId);
    }
}
