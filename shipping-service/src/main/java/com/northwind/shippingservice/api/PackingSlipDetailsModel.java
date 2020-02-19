package com.northwind.shippingservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@JsonSerialize
public class PackingSlipDetailsModel {
    @JsonProperty
    private long packingSlipDetailsId;
    @JsonProperty
    private long packingSlipId;
    @JsonProperty
    private String productName;
    @JsonProperty
    private int quantity;
    @JsonProperty
    private long version;

    public long getPackingSlipDetailsId() {
        return packingSlipDetailsId;
    }

    public long getPackingSlipId() {
        return packingSlipId;
    }

    public void setPackingSlipId(long packingSlipId) {
        this.packingSlipId = packingSlipId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public void setPackingSlipDetailsId(long packingSlipDetailsId) {
        this.packingSlipDetailsId = packingSlipDetailsId;
    }
}
