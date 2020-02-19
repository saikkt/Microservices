package com.northwind.shippingservice.repository;

import com.northwind.shippingservice.domain.PackingSlip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingSlipRepository extends JpaRepository<PackingSlip,Long> {
}
