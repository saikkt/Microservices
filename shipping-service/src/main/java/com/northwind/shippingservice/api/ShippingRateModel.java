package com.northwind.shippingservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import java.math.BigDecimal;

@JsonSerialize
public class ShippingRateModel {

    @JsonProperty
    private long shippingRateID;
    @JsonProperty
    private String country;
    @JsonProperty
    private BigDecimal flatRate;
    @JsonProperty
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
