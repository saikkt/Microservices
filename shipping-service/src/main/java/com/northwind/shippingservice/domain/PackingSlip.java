package com.northwind.shippingservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="PackingSlips")
public class PackingSlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PackingSlipID")
    private long packingSlipId;
    @Column(name ="OrderID")
    private long orderId;
    @Column(name="ShipName")
    private String shipName;
    @Column(name ="ShipAddress")
    private String shipAddress;
    @Column(name="ShipCity")
    private String shipCity;
    @Column(name="ShipRegion")
    private String shipRegion;
    @Column(name="ShipPostalCode")
    private String shipPostalCode;
    @Column(name="ShipCountry")
    private String shipCountry;
    @Column(name="Version")
    private long version;

    public PackingSlip(){

    }
    public PackingSlip(long packingSlipId){
        this.packingSlipId = packingSlipId;
    }
    @OneToMany(mappedBy = "packingSlip",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PackingSlipDetails> packingSlipDetailsList = new ArrayList<>();

    public List<PackingSlipDetails> getPackingSlipDetailsList() {
        return packingSlipDetailsList;
    }

    public void setPackingSlipDetailsList(List<PackingSlipDetails> packingSlipDetailsList) {
        this.packingSlipDetailsList = packingSlipDetailsList;
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

    public void addItem(PackingSlipDetails packingSlipDetails){
        packingSlipDetailsList.add(packingSlipDetails);
        packingSlipDetails.setPackingSlip(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackingSlip)) return false;
        PackingSlip that = (PackingSlip) o;
        return packingSlipId == that.packingSlipId &&
                orderId == that.orderId &&
                version == that.version &&
                Objects.equals(shipName, that.shipName) &&
                Objects.equals(shipAddress, that.shipAddress) &&
                Objects.equals(shipCity, that.shipCity) &&
                Objects.equals(shipRegion, that.shipRegion) &&
                Objects.equals(shipPostalCode, that.shipPostalCode) &&
                Objects.equals(shipCountry, that.shipCountry) &&
                Objects.equals(packingSlipDetailsList, that.packingSlipDetailsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packingSlipId, orderId, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry, version, packingSlipDetailsList);
    }
}
