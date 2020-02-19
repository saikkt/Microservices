package com.northwind.catalogservice.api;

import com.northwind.catalogservice.domain.Product;

public class ProductMapper {
    public static ProductModel toModel(Product product){
        ProductModel productModel = new ProductModel();
        productModel.setProductId(product.getProductId());
        productModel.setListPrice(product.getListPrice());
        productModel.setProductName(product.getProductName());
        productModel.setPublished(product.isPublished());
        productModel.setCategoryId(product.getCategory().getCategoryId());

        return productModel;
    }

    public static Product toEntity(ProductModel productModel){
       Product product = new Product(productModel.getProductName(),productModel.isPublished());
       product.setListPrice(productModel.getListPrice());
       product.setQuantityPerUnit(productModel.getQuantityPerUnit());

       return product;
    }
}
