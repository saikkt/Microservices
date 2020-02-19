package com.northwind.inventoryservice.api;


import com.northwind.inventoryservice.domain.Products;

public class ProductsMapper {

    public static ProductsModel toModel(Products entity) {
        ProductsModel model = new ProductsModel();
        model.setId(entity.getId());
        model.setDiscontinued(entity.isDiscontinued());
        model.setLocation(entity.getLocation());
        model.setProductName(entity.getProductName());
        model.setQuantityPerUnit(entity.getQuantityPerUnit());
        model.setReorderLevel(entity.getReorderLevel());
        model.setUnitPrice(entity.getUnitPrice());
        model.setUnitsInStock(entity.getUnitsInStock());
        model.setUnitsOnOrder(entity.getUnitsOnOrder());
        model.setVersion(entity.getVersion());
        model.setSupplierID(entity.getSupplierId());
        model.setSuppliers(SupplierMapper.toModel(entity.getSupplier()));
        return model;
    }

    public static Products toEntity(ProductsModel model) {
        Products entity = new Products(model.getProductName());
        entity.setDiscontinued(model.isDiscontinued());
        entity.setLocation(model.getLocation());
        entity.setProductName(model.getProductName());
        entity.setQuantityPerUnit(model.getQuantityPerUnit());
        entity.setReorderLevel(model.getReorderLevel());
        entity.setUnitPrice(model.getUnitPrice());
        entity.setUnitsInStock(model.getUnitsInStock());
        entity.setUnitsOnOrder(model.getUnitsOnOrder());
        entity.setSupplierId(model.getSupplierID());
       // entity.addSupplier(SupplierMapper.toEntity(model.getSuppliers()));
        return entity;
    }

    public static Products merge(ProductsModel model, Products entity) {
        entity.setProductName(model.getProductName());
        entity.setDiscontinued(model.isDiscontinued());
        entity.setLocation(model.getLocation());
        entity.setProductName(model.getProductName());
        entity.setQuantityPerUnit(model.getQuantityPerUnit());
        entity.setReorderLevel(model.getReorderLevel());
        entity.setUnitPrice(model.getUnitPrice());
        entity.setUnitsInStock(model.getUnitsInStock());
        entity.setUnitsOnOrder(model.getUnitsOnOrder());
        entity.setSupplierId(model.getSupplierID());
        return entity;
    }
}
