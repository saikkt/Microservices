package com.northwind.inventoryservice.api;

import com.northwind.inventoryservice.domain.Products;
import com.northwind.inventoryservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<ProductsModel>> getAll(){

        List<Products> products= productsService.getAll();
        return ResponseEntity.ok().body(products.stream().map(p->{return ProductsMapper.toModel(p);}).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductsModel> getById(@PathVariable long id){
        Optional<Products> products = productsService.findById(id);

        if(!products.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(ProductsMapper.toModel(products.get()));
    }

    @PostMapping
    public ResponseEntity<ProductsModel> create(@RequestBody ProductsModel model) {
        Products product = ProductsMapper.toEntity(model);
        product = productsService.save(product);
        return ResponseEntity.created(URI.create(String.format("/products/%s", product.getId())))
                .body(ProductsMapper.toModel(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductsModel> update(@PathVariable long id, @RequestBody ProductsModel model) {
        Optional<Products> product = productsService.findById(id);
        if (!product.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Products savedProduct = product.get();
        ProductsMapper.merge(model,savedProduct);
        productsService.save(savedProduct);
        return ResponseEntity.ok(ProductsMapper.toModel(savedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        productsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
