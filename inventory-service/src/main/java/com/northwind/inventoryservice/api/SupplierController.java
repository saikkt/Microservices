package com.northwind.inventoryservice.api;

import com.northwind.inventoryservice.domain.Products;
import com.northwind.inventoryservice.domain.Supplier;
import com.northwind.inventoryservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable long id){

        Optional<Products> products = productsService.findById(id);

        if(!products.isPresent())
            return ResponseEntity.notFound().build();

        Supplier supplier = products.get().getSupplier();

        return ResponseEntity.ok().body(supplier);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Products> postSupplier(@PathVariable long id,@RequestBody SupplierModel supplierModel){

        Optional<Products> products = productsService.findById(id);

        if(!products.isPresent())
            return ResponseEntity.notFound().build();

        Products existingProduct = products.get();
        Supplier existingSupplier = existingProduct.getSupplier();
        SupplierMapper.merge(supplierModel,existingSupplier);
        existingProduct.setSupplier(existingSupplier);

        productsService.save(existingProduct);
        return ResponseEntity.created(URI.create("/suppliers/"+String.valueOf(id))).body(existingProduct);
    }

//    @PostMapping
//    public ResponseEntity<Supplier> postSupplier(@RequestBody Supplier supplier){
//
//        Supplier savedSupplier = supplierService.createOrUpdateSupplier(supplier);
//        return ResponseEntity.created(URI.create("/suppliers/"+String.valueOf(savedSupplier.getId()))).body(savedSupplier);
//    }
//
//    @PutMapping("/{id}")
//    public  ResponseEntity<Supplier> updateSupplier(@RequestBody SupplierModel supplierModel,@PathVariable long id){
//
//        Optional<Supplier> supplier= supplierService.getById(id);
//        if(!supplier.isPresent())
//            return ResponseEntity.noContent().build();
//        Supplier existingSupplier = supplier.get();
//        SupplierMapper.merge(supplierModel,existingSupplier);
//        Supplier updatedSupplier = supplierService.createOrUpdateSupplier(existingSupplier);
//        return ResponseEntity.ok().body(updatedSupplier);
//    }
//
//    @DeleteMapping("{/id}")
//    public ResponseEntity deleteSupplier(@PathVariable long id){
//        supplierService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

}
