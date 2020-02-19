package com.northwind.inventoryservice.repositories;

import com.northwind.inventoryservice.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {

}
