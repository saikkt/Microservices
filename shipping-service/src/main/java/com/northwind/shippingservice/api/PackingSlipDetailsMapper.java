package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.PackingSlipDetails;

public class PackingSlipDetailsMapper {
    public static PackingSlipDetailsModel toModel(PackingSlipDetails packingSlipDetails){
        PackingSlipDetailsModel packingSlipModel = new PackingSlipDetailsModel();
        packingSlipModel.setPackingSlipDetailsId(packingSlipDetails.getPackingSlipDetailsId());
        packingSlipModel.setPackingSlipId(packingSlipDetails.getPackingSlip().getPackingSlipId());
        packingSlipModel.setProductName(packingSlipDetails.getProductName());
        packingSlipModel.setQuantity(packingSlipDetails.getQuantity());
        packingSlipModel.setVersion(packingSlipDetails.getVersion());
        return packingSlipModel;
    }

    public static PackingSlipDetails toEntity(PackingSlipDetailsModel packingSlipDetailsModel)
    {
        PackingSlipDetails packingSlipDetails = new PackingSlipDetails();
        packingSlipDetails.setProductName(packingSlipDetailsModel.getProductName());
        packingSlipDetails.setQuantity(packingSlipDetailsModel.getQuantity());

        return packingSlipDetails;
    }
}
