package com.northwind.shippingservice.service;

import com.northwind.shippingservice.domain.Shipper;
import com.northwind.shippingservice.repository.ShipperRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperService {
    private ShipperRepository shipperRepository;

    public ShipperService(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    public Optional<Shipper> getById(long id){
        return shipperRepository.findById(id);
    }

    public List<Shipper> getAll(int page, int size){
        return shipperRepository.findAll(PageRequest.of(page,size)).toList();
    }

    public List<Shipper> getByCompanyName(String compnayName){
        return shipperRepository.getBycompanyName(compnayName);
    }
}
