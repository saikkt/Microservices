package com.northwind.shippingservice.repository;

import com.northwind.shippingservice.domain.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper,Long> {
    List<Shipper> getBycompanyName(String companyName);
}
