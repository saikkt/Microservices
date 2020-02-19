package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.ShippingRate;
import com.northwind.shippingservice.service.ShippingRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shippingrates")
public class ShippingRateController {
    private ShippingRateService shippingRateService;

    public ShippingRateController(ShippingRateService shippingRateService) {
        this.shippingRateService = shippingRateService;
    }

    @GetMapping
    public ResponseEntity<List<ShippingRateModel>> get(@RequestParam(required = false) Optional<Integer> page,
                                                       @RequestParam(required = false) Optional<Integer> size){
        List<ShippingRateModel> modelList = shippingRateService.getAllShippingRates(page.orElse(0),size.orElse(10)).stream()
                .map(s->ShippingRateMapper.toModel(s))
                .collect(Collectors.toList());

        return new ResponseEntity<>(modelList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingRateModel> get(@PathVariable long id){
        Optional<ShippingRate> shippingRate = shippingRateService.getById(id);
        ShippingRateModel shippingRateModel = ShippingRateMapper.toModel(shippingRate.get());
        return ResponseEntity.ok(shippingRateModel);
    }

    @GetMapping(params = "country")
    public ResponseEntity<List<ShippingRateModel>> get(@RequestParam String country){
        List<ShippingRateModel> shippingRateModelList = shippingRateService.getByCountry(country).stream()
                                                        .map(s->ShippingRateMapper.toModel(s))
                                                        .collect(Collectors.toList());
        return ResponseEntity.ok(shippingRateModelList);
    }

    @PostMapping
    public ResponseEntity<ShippingRateModel> post(@RequestBody ShippingRateModel shippingRateModel){
        ShippingRate shippingRate = ShippingRateMapper.toEntity(shippingRateModel);
        ShippingRate savedShippingRate = shippingRateService.save(shippingRate);
        ShippingRateModel savedshippingRateModel = ShippingRateMapper.toModel(savedShippingRate);
        return ResponseEntity.created(URI.create("shippingrates/"+savedshippingRateModel.getShippingRateID())).body(savedshippingRateModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id){
        shippingRateService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
