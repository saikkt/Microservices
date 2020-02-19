package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.PackingSlip;
import com.northwind.shippingservice.service.PackingSlipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/packingslips")
public class PackingSlipController {

    private PackingSlipService packingSlipService;

    public PackingSlipController(PackingSlipService packingSlipService) {
        this.packingSlipService = packingSlipService;
    }

    @GetMapping
    public ResponseEntity<List<PackingSlipModel>> get(@RequestParam(required = false)Optional<Integer> page,
                                                      @RequestParam(required = false)Optional<Integer> size){

        List<PackingSlipModel> packingSlipModels = packingSlipService.getAll(page.orElse(0),size.orElse(10)).stream()
                                                    .map(p->PackingSlipMapper.toModel(p))
                                                    .collect(Collectors.toList());

        return ResponseEntity.ok(packingSlipModels);
    }
    @PostMapping
    public ResponseEntity<PackingSlipModel> create(@RequestBody PackingSlipModel packingSlipModel){
       PackingSlip savedPackingSlip =  packingSlipService.save(PackingSlipMapper.toEntity(packingSlipModel));
       PackingSlipModel savedPackingSlipModel = PackingSlipMapper.toModel(savedPackingSlip);
       return ResponseEntity.ok(savedPackingSlipModel);
    }
}
