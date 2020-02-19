package com.northwind.catalogservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.northwind.catalogservice.domain.Product;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import java.sql.Blob;
import java.util.List;
import java.util.UUID;

@JsonSerialize
public class CategoryModel {
    @JsonProperty
    private long categoryId;

    @JsonProperty
    private String categoryName;

    @JsonProperty
    private String description;


    @JsonProperty
    private long Version;

 //   @JsonProperty
    private List<ProductModel> productModelList;

    public List<ProductModel> getProductModelList() {
        return productModelList;
    }

    public void setProductModelList(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



   // public long getVersion() {
  //      return Version;
   // }

    public void setVersion(long version) {
        Version = version;
    }

}
