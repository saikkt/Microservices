package com.northwind.shippingservice.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ShippingRates")
public class ShippingRate {

    @Column(name = "ShippingRateID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long shippingRateID;
    @Column(name = "Country")
    private String country;
    @Column(name = "FlatRate")
    private BigDecimal flatRate;
    @Column(name = "Version")
    private long version;

    public long getShippingRateID() {
        return shippingRateID;
    }

    public void setShippingRateID(long shippingRateID) {
        this.shippingRateID = shippingRateID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getFlatRate() {
        return flatRate;
    }

    public void setFlatRate(BigDecimal flatRate) {
        this.flatRate = flatRate;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
