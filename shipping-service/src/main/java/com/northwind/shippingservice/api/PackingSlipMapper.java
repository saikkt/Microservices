package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.PackingSlip;
import com.northwind.shippingservice.domain.PackingSlipDetails;

import java.util.List;
import java.util.stream.Collectors;

public class PackingSlipMapper {

    public static PackingSlipModel toModel(PackingSlip entity){
        PackingSlipModel packingSlipModel = new PackingSlipModel();
        packingSlipModel.setOrderId(entity.getOrderId());
        packingSlipModel.setPackingSlipId(entity.getPackingSlipId());
        packingSlipModel.setShipAddress(entity.getShipAddress());
        packingSlipModel.setShipCity(entity.getShipCity());
        packingSlipModel.setShipName(entity.getShipName());
        packingSlipModel.setShipCountry(entity.getShipCountry());
        packingSlipModel.setShipRegion(entity.getShipRegion());
        packingSlipModel.setShipPostalCode(entity.getShipPostalCode());
        packingSlipModel.setVersion(entity.getVersion());
        List<PackingSlipDetailsModel> list = entity.getPackingSlipDetailsList().stream()
                .map(p->PackingSlipDetailsMapper.toModel(p)).collect(Collectors.toList());
        packingSlipModel.setPackingSlipDetailsList(list);

        return packingSlipModel;
    }

    public static PackingSlip toEntity(PackingSlipModel packingSlipModel){
        PackingSlip packingSlip = new PackingSlip(packingSlipModel.getPackingSlipId());
        packingSlip.setOrderId(packingSlipModel.getOrderId());
        packingSlip.setPackingSlipId(packingSlipModel.getPackingSlipId());
        packingSlip.setShipAddress(packingSlipModel.getShipAddress());
        packingSlip.setShipName(packingSlipModel.getShipName());
        packingSlip.setShipCountry(packingSlipModel.getShipCountry());
        packingSlip.setShipRegion(packingSlipModel.getShipRegion());
        packingSlip.setShipPostalCode(packingSlipModel.getShipPostalCode());
        packingSlipModel.getPackingSlipDetailsModelList().stream()
                .forEach(
                        packingSlipDetailsModel ->
                                packingSlip.addItem(PackingSlipDetailsMapper.toEntity(packingSlipDetailsModel)));
        return packingSlip;
    }
}
