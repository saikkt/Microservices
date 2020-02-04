package com.northwind.shippingservice.repositories;

import com.northwind.shippingservice.domain.ShippingRates;

import java.util.List;

public interface ShippingRatesRepository extends Repository<ShippingRates> {

   List<ShippingRates>  getByCountry(String country);

}
