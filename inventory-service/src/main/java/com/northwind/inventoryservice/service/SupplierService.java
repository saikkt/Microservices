package com.northwind.inventoryservice.service;

import com.northwind.inventoryservice.domain.Supplier;
import com.northwind.inventoryservice.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Supplier postSupplier(Supplier supplier){
        return supplierRepository.saveAndFlush(supplier);
    }
}
