package com.northwind.shippingservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;

@JsonSerialize
public class ShipperModel {
    @JsonProperty
    private long shipperId;
    @JsonProperty
    private String companyName;
    @JsonProperty
    private String phone;
    @JsonProperty
    private long version;

    public long getShipperId() {
        return shipperId;
    }

    public void setShipperId(long shipperId) {
        this.shipperId = shipperId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
