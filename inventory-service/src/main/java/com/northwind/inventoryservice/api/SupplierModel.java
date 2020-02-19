package com.northwind.inventoryservice.api;

import com.northwind.inventoryservice.domain.Products;
import com.northwind.inventoryservice.domain.Supplier;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SupplierModel {


    private long id;
    private String companyName;
    private String contactName;

    private String contactTitle;

    private String address;

    private String city;

    private String region;

    private String postalCode;

    private String country;

    private String phone;

    private String fax;

    private String homePage;

    private long version;

    private UUID objectId;

   // private List<Products> products;

    public SupplierModel() {}

    public SupplierModel(String companyName, String postalCode) {
        setCompanyName(companyName);
        setPostalCode(postalCode);
        this.objectId = UUID.randomUUID();
        this.version = 1;
    }

    public long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public long getVersion() {
        return version;
    }

//  //  public List<Products> getProducts() {
//        return Collections.unmodifiableList(products);
//    }

    public void addProduct(Products products) {
    }

    public void removeProduct(Products products) {

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public UUID getObjectId() {
        return objectId;
    }

    public void setObjectId(UUID objectId) {
        this.objectId = objectId;
    }

//    public void setProducts(List<Products> products) {
//        this.products = products;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(objectId);
    }
}
