package com.northwind.shippingservice.service;

import com.northwind.shippingservice.domain.PackingSlip;
import com.northwind.shippingservice.domain.PackingSlipDetails;
import com.northwind.shippingservice.repository.PackingSlipRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackingSlipService {
    private PackingSlipRepository packingSlipRepository;

    public PackingSlipService(PackingSlipRepository packingSlipRepository) {
        this.packingSlipRepository = packingSlipRepository;
    }

    public List<PackingSlip> getAll(int page, int size){
       return packingSlipRepository.findAll(PageRequest.of(page,size)).toList();
    }

    public PackingSlip save(PackingSlip packingSlip){
      //packingSlip.addItem(packingSlip.getPackingSlipDetailsList());
      //.getPackingSlipDetailsList().stream().map(p->packingSlip.addItem(p));
        return packingSlipRepository.save(packingSlip);
    }
}
