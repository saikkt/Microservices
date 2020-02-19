package com.northwind.catalogservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.northwind.catalogservice.domain.Category;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.util.UUID;

@JsonSerialize
public class ProductModel {
    @JsonProperty
    private long productId;

    @JsonProperty
    private String productName;

    @JsonProperty
    private long categoryId;

    @JsonProperty
    private String quantityPerUnit;

    @JsonProperty
    private double listPrice;

    @JsonProperty
    private boolean published;

    @JsonProperty
    private long Version;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

   // public long getVersion() {
    //    return Version;
   // }

    public void setVersion(long version) {
        Version = version;
    }
}
