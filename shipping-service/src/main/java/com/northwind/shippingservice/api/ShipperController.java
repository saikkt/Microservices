package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.Shipper;
import com.northwind.shippingservice.service.ShipperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shippers")
public class ShipperController {
    private ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping
    public ResponseEntity<List<ShipperModel>> get(@RequestParam (required = false) Optional<Integer> page,
                                                  @RequestParam (required = false) Optional<Integer> size){
        List<ShipperModel> shipperModels = shipperService.getAll(page.orElse(0),size.orElse(10)).stream()
                .map(s->ShipperMapper.toModel(s))
                .collect(Collectors.toList());
        return ResponseEntity.ok(shipperModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipperModel> get(@PathVariable long id){
        Optional<Shipper> shipper = shipperService.getById(id);
        if(!shipper.isPresent()){
            return ResponseEntity.notFound().build();
        }
        ShipperModel model = ShipperMapper.toModel(shipper.get());
        return ResponseEntity.ok(model);
    }

    @GetMapping(params = "companyName")
    public ResponseEntity<List<ShipperModel>> get(@RequestParam String companyName){
        List<ShipperModel> shipperModels = shipperService.getByCompanyName(companyName).stream()
                                            .map(c->ShipperMapper.toModel(c))
                                            .collect(Collectors.toList());
        return ResponseEntity.ok(shipperModels);
    }
}
