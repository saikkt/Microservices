package com.northwind.shippingservice.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.northwind.shippingservice.domain.PackingSlipDetails;

import java.util.List;

@JsonSerialize
public class PackingSlipModel {
    private long packingSlipId;
    @JsonProperty
    private long orderId;
    @JsonProperty
    private String shipName;
    @JsonProperty
    private String shipAddress;
    @JsonProperty
    private String shipCity;
    @JsonProperty
    private String shipRegion;
    @JsonProperty
    private String shipPostalCode;
    @JsonProperty
    private String shipCountry;
    @JsonProperty
    private long version;
    @JsonProperty
    private List<PackingSlipDetailsModel> packingSlipDetailsModelList;

    @JsonIgnore
    public List<PackingSlipDetailsModel> getPackingSlipDetailsModelList() {
        return packingSlipDetailsModelList;
    }

    public void setPackingSlipDetailsList(List<PackingSlipDetailsModel> packingSlipDetailsModelList) {
        this.packingSlipDetailsModelList = packingSlipDetailsModelList;
    }

    public long getPackingSlipId() {
        return packingSlipId;
    }

    public void setPackingSlipId(long packingSlipId) {
        this.packingSlipId = packingSlipId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
