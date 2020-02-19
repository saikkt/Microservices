package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.Shipper;

public class ShipperMapper {

    public static ShipperModel toModel(Shipper entity){
        ShipperModel shipperModel = new ShipperModel();
        shipperModel.setShipperId(entity.getShipperId());
        shipperModel.setCompanyName(entity.getCompanyName());
        shipperModel.setPhone(entity.getPhone());
        shipperModel.setVersion(entity.getVersion());

        return shipperModel;
    }

    public static Shipper toEntity(ShipperModel shipperModel){
        Shipper shipper = new Shipper();
        shipper.setCompanyName(shipperModel.getCompanyName());
        shipper.setPhone(shipperModel.getPhone());
        shipper.setVersion(shipperModel.getVersion());

        return shipper;
    }
}
