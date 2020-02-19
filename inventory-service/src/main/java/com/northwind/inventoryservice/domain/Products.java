package com.northwind.inventoryservice.domain;

import jdk.internal.jline.internal.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="Products")
public class Products {
    @Id
    @Column(name="ProductID")
    private long id;
    @Column
    private String productName;
    @Column
    private String quantityPerUnit;
    @Column
    private BigDecimal unitPrice;
    @Column
    private int unitsInStock;
    @Column
    private int unitsOnOrder;
    @Column
    private int reorderLevel;
    @Column
    private boolean discontinued;
    @Column
    private String location;
    @Version
    private long version;
    @Column
    private UUID objectId;
    @Column(name="SupplierID")
    @Nullable
    private Long supplierId;

    @ManyToOne
    @JoinColumn(name = "SupplierID",updatable = false,insertable = false)
    private Supplier supplier;

    protected Products() {}

    public Products(String productName) {
        setProductName(productName);
        setDiscontinued(false);
        this.objectId = UUID.randomUUID();
        this.version = 1;
    }

    public long getId() {
        return id;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public long getVersion() {
        return version;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return objectId.equals(products.objectId);
    }

    public void addSupplier(Supplier supplier){
         this.supplier=supplier;
//        supplier.getProducts().add(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId);
    }
}