package com.northwind.shippingservice.repository;

import com.northwind.shippingservice.domain.ShippingRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingRateRepository extends JpaRepository<ShippingRate,Long> {

    public List<ShippingRate> getByCountry(String country);
}
