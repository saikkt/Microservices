package com.northwind.catalogservice.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name ="Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private long productId;

    @Column(name ="ProductName")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private Category category;

    @Column (name="QuantityPerUnit")
    private String quantityPerUnit;

    @Column(name = "ListPrice")
    private double listPrice;

    @Column(name ="Published")
    private boolean published;

    @Version
    private long Version;

    @Column (name="ObjectID")
    private UUID objectId;

    public Product(String productName, boolean published) {
        this.productName = productName;
        this.published = published;
    }
    protected Product(){}

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public boolean isPublished() {
        return published;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        this.objectId = objectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Double.compare(product.listPrice, listPrice) == 0 &&
                published == product.published &&
                Version == product.Version &&
                productName.equals(product.productName) &&
                Objects.equals(category, product.category) &&
                Objects.equals(quantityPerUnit, product.quantityPerUnit) &&
                Objects.equals(objectId, product.objectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, category, quantityPerUnit, listPrice, published, Version, objectId);
    }
}
