package com.northwind.catalogservice.api;

import com.northwind.catalogservice.domain.Category;
import com.northwind.catalogservice.domain.Product;
import com.northwind.catalogservice.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories/{categoryId}/products")
public class ProductController {

    private CategoryService categoryService;

    public ProductController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductModel> get(@PathVariable long categoryId,@PathVariable long productId){
        Optional<Category> category = categoryService.getbyId(categoryId);
        if(!category.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Optional<Product> product = category.get().getProductList().stream()
                .filter(p->p.getProductId()==productId)
                .findFirst();
        if(!product.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProductMapper.toModel(product.get()));

    }

//    @PostMapping
//    public ResponseEntity<ProductModel> create(@PathVariable long categoryId, @RequestBody ProductModel productModel){
//        Optional<Category> category = categoryService.getbyId(categoryId);
//        if(!category.isPresent()){
//            return ResponseEntity.notFound().build();
//        }
//        category.get().

  //  }
}
