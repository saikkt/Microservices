package com.northwind.inventoryservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.northwind.inventoryservice.domain.Supplier;
import jdk.internal.jline.internal.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductsModel {

    @JsonProperty
    private long id;
    @JsonProperty
    private String productName;
    @JsonProperty
    private String quantityPerUnit;
    @JsonProperty
    private BigDecimal unitPrice;
    @JsonProperty
    private int unitsInStock;
    @JsonProperty
    private int unitsOnOrder;
    @JsonProperty
    private int reorderLevel;
    @JsonProperty
    private boolean discontinued;
    @JsonProperty
    private String location;
    @JsonProperty
    private long version;
    @JsonProperty
    @Nullable
    private Long SupplierID;

    private SupplierModel supplierModel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(int unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public SupplierModel getSuppliers() {
        return supplierModel;
    }

    public void setSuppliers(SupplierModel suppliers) {
        this.supplierModel = suppliers;
    }

    public Long getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(Long supplierID) {
        SupplierID = supplierID;
    }
}
