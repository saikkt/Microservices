package com.northwind.catalogservice.domain;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private long categoryId;

    @Column(name ="CategoryName")
    private String categoryName;

    @Column(name ="Description")
    private String description;


    @Version
    private long Version;

    @Column(name = "ObjectID")
    private UUID objectId;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    protected Category(){}

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public long getVersion() {
        return Version;
    }

    public void setVersion(long version) {
        Version = version;
    }

    public UUID getObjectId() {
        return objectId;
    }


    public void setObjectId(UUID objectId) {
        this.objectId = UUID.randomUUID();
    }

    public void addProduct(Product product){
        productList.add(product);
        product.setCategory(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId &&
                Version == category.Version &&
                categoryName.equals(category.categoryName) &&
                Objects.equals(description, category.description) &&
                Objects.equals(objectId, category.objectId) &&
                Objects.equals(productList, category.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryName, description,Version, objectId, productList);
    }
}
