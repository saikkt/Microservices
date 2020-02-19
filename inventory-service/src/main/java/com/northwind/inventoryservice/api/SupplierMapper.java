package com.northwind.inventoryservice.api;

import com.northwind.inventoryservice.domain.Products;
import com.northwind.inventoryservice.domain.Supplier;

public class SupplierMapper {


    public static SupplierModel toModel(Supplier supplier) {
        SupplierModel supplierModel = new SupplierModel();
        supplierModel.setId(supplier.getId());
        supplierModel.setAddress(supplier.getAddress());
        supplierModel.setCity(supplier.getCity());
        supplierModel.setCompanyName(supplier.getCompanyName());
        supplierModel.setContactName(supplier.getContactName());
        supplierModel.setContactTitle(supplier.getContactTitle());
        supplierModel.setFax(supplier.getFax());
        supplierModel.setHomePage(supplier.getHomePage());
        supplierModel.setPhone(supplier.getPhone());
        supplierModel.setPostalCode(supplier.getPostalCode());
        return supplierModel;
    }

    public static Supplier toEntity(SupplierModel model) {
        Supplier supplier = new Supplier(model.getCompanyName(),model.getPostalCode());
        supplier.setId(model.getId());
        supplier.setAddress(supplier.getAddress());
        supplier.setCity(supplier.getCity());
        supplier.setContactName(supplier.getContactName());
        supplier.setContactTitle(supplier.getContactTitle());
        supplier.setFax(supplier.getFax());
        supplier.setHomePage(supplier.getHomePage());
        supplier.setPhone(supplier.getPhone());
     //   supplier.setProducts(supplier.getProducts());
        return supplier;
    }

    public static Supplier merge(SupplierModel supplierModel, Supplier supplier) {
        supplier.setId(supplierModel.getId());
        supplier.setAddress(supplierModel.getAddress());
        supplier.setCity(supplierModel.getCity());
        supplier.setContactName(supplierModel.getContactName());
        supplier.setContactTitle(supplierModel.getContactTitle());
        supplier.setFax(supplierModel.getFax());
        supplier.setHomePage(supplierModel.getHomePage());
        supplier.setPhone(supplierModel.getPhone());
       // supplier.setProducts(supplierModel.getProducts());
        supplier.setCompanyName(supplierModel.getCompanyName());
        supplier.setPostalCode(supplierModel.getPostalCode());
        return supplier;
    }
}
