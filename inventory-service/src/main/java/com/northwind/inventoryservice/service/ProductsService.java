package com.northwind.inventoryservice.service;

import com.northwind.inventoryservice.api.ProductsMapper;
import com.northwind.inventoryservice.domain.Products;
import com.northwind.inventoryservice.domain.Supplier;
import com.northwind.inventoryservice.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductsService {

    @Autowired
    ProductsRepository repository;

    public List<Products> getAll(){
        return repository.findAll();
    }

    public Optional<Products> findById(long id){
        return repository.findById(id);
    }

    public Products save(Products product) {
        return repository.saveAndFlush(product);
    }

    public void delete(long id) {
       repository.deleteById(id);
    }


}
