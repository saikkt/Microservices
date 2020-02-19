package com.northwind.shippingservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PackingSlipDetails")
public class PackingSlipDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "PackingSlipDetailsID")
    private long packingSlipDetailsId;
    public PackingSlipDetails(){}
    public PackingSlip getPackingSlip() {
        return packingSlip;
    }

    public void setPackingSlip(PackingSlip packingSlip) {
        this.packingSlip = packingSlip;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "PackingSlipID", referencedColumnName = "PackingSlipID")
    private PackingSlip packingSlip;
    @Column(name="ProductName")
    private String productName;
    @Column(name="Quantity")
    private int quantity;
    @Version
    private long version;

    public long getPackingSlipDetailsId() {
        return packingSlipDetailsId;
    }

    public void setPackingSlipDetailsId(long packingSlipDetailsId) {
        this.packingSlipDetailsId = packingSlipDetailsId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PackingSlipDetails)) return false;
        PackingSlipDetails that = (PackingSlipDetails) o;
        return packingSlipDetailsId == that.packingSlipDetailsId &&
                quantity == that.quantity &&
                version == that.version &&
                Objects.equals(packingSlip, that.packingSlip) &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packingSlipDetailsId, packingSlip, productName, quantity, version);
    }
}
