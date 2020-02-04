package com.northwind.shippingservice.domain;

public class ShippingRates {

    private long id;
    private String country;
    private double flatRate;
    private long version;

    public ShippingRates(long id){
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        if(id == 0)
            throw new IllegalArgumentException("ID cannot be zero");
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getFlatRate() {
        return flatRate;
    }

    public void setFlatRate(double flatRate) {
        this.flatRate = flatRate;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        if(version == 0)
         throw new IllegalArgumentException("Version cannot be zero");

        if(version < this.version)
            throw new IllegalArgumentException("Version cannot be older than previous version");
        this.version = version;
    }
}
