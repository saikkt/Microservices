package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.ShippingRates;

class ShippingRatesMapper {
    private ShippingRatesMapper(){}

    public static ShippingRatesModel toModel(ShippingRates entity){
        ShippingRatesModel model = new ShippingRatesModel();
       model.setId(entity.getId());
        model.setCountry(entity.getCountry());
        model.setFlatRate(entity.getFlatRate());
        model.setVersion(entity.getVersion());

        return model;
    }

    public static ShippingRates toEntity(ShippingRatesModel model){
        ShippingRates shippingRates = new ShippingRates(model.getId());
      //  shippingRates.setId(model.getId());
        shippingRates.setCountry(model.getCountry());
        shippingRates.setFlatRate(model.getFlatRate());
       // shippingRates.setVersion(model.getVersion());

        return shippingRates;
    }

    public static ShippingRates toEntity(ShippingRatesModel model,ShippingRates entity){
        //ShippingRates shippingRates = new ShippingRates(model.getId());
        //shippingRates.setId(model.getId());
        entity.setCountry(model.getCountry());
        entity.setFlatRate(model.getFlatRate());
        entity.setVersion(model.getVersion());

        return entity;
    }
}
