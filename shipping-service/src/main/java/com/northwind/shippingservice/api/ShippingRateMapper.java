package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.ShippingRate;

public class ShippingRateMapper {

    public static ShippingRateModel toModel(ShippingRate entity){
        ShippingRateModel shippingRateModel = new ShippingRateModel();
        shippingRateModel.setShippingRateID(entity.getShippingRateID());
        shippingRateModel.setCountry(entity.getCountry());
        shippingRateModel.setFlatRate(entity.getFlatRate());
        shippingRateModel.setVersion(entity.getVersion());

        return shippingRateModel;
    }

    public static ShippingRate toEntity(ShippingRateModel model){
        ShippingRate shippingRate = new ShippingRate();
        shippingRate.setShippingRateID(model.getShippingRateID());
        shippingRate.setCountry(model.getCountry());
        shippingRate.setFlatRate(model.getFlatRate());
        shippingRate.setVersion(model.getVersion());

        return shippingRate;
    }
}
