package com.northwind.shippingservice.domain;

import javax.persistence.*;

@Entity
@Table (name = "Shippers")
public class Shipper {
    @Column (name = "ShipperID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private long shipperId;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name ="Phone")
    private String phone;
    @Column(name="Version")
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
