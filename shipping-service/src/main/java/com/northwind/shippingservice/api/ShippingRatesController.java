package com.northwind.shippingservice.api;

import com.northwind.shippingservice.domain.ShippingRates;
import com.northwind.shippingservice.services.ShippingRatesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/shippingrates")
public class ShippingRatesController {

    private ShippingRatesService shippingRatesService;

    public ShippingRatesController(ShippingRatesService shippingRatesService){
        this.shippingRatesService = shippingRatesService;
    }

    @GetMapping
    public ResponseEntity<List<ShippingRatesModel>> get (@RequestParam(required = false)Optional<Integer> offset,
                                                         @RequestParam(required = false) Optional<Integer> limit){
        int skip = offset.orElse(0);
        int take = limit.orElse(50);

        if(take>50){
            throw new IllegalArgumentException("Limit cannot be more than 50");
        }
       List<ShippingRatesModel> shippingRatesModel =  shippingRatesService.getAll(skip,take)
                .stream()
                .map(ShippingRatesMapper::toModel)
                .collect(Collectors.toList());

        return new ResponseEntity<>(shippingRatesModel, HttpStatus.OK);

    }

    @GetMapping(path = ("/{id}"))
    public ShippingRatesModel getById(@PathVariable long id){
        ShippingRates entity = shippingRatesService.getById(id);
        ShippingRatesModel model = ShippingRatesMapper.toModel(entity);

        return model;
    }

    @PostMapping
    public  ResponseEntity<ShippingRatesModel> create(@RequestBody ShippingRatesModel shippingRatesModel)
    {
        ShippingRates shippingRates = ShippingRatesMapper.toEntity(shippingRatesModel);
        ShippingRates savedRate = shippingRatesService.save(shippingRates);
        return ResponseEntity.created(URI.create("/shippingrates/"+savedRate.getId()))
                .body(ShippingRatesMapper.toModel(savedRate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingRatesModel> update(@PathVariable long id, @RequestBody ShippingRatesModel shippingRatesModel){
        ShippingRates exisitingRate = shippingRatesService.getById(id);

        if(exisitingRate == null){
            return ResponseEntity.notFound().build();
        }

        if(exisitingRate.getVersion() != shippingRatesModel.getVersion()){
            return new ResponseEntity<>(ShippingRatesMapper.toModel(exisitingRate),HttpStatus.CONFLICT);
        }

        ShippingRates mergedRate = ShippingRatesMapper.toEntity(shippingRatesModel,exisitingRate);

        ShippingRates savedRate = shippingRatesService.save(mergedRate);

        return new ResponseEntity<>(ShippingRatesMapper.toModel(savedRate),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        ShippingRates existingRate = shippingRatesService.getById(id);
        if(existingRate ==null) return;

        shippingRatesService.delete(existingRate);
    }

    @GetMapping(params = "countryName")
    public ResponseEntity<List<ShippingRatesModel>> findByCustomerName(@RequestParam String countryName) {
        return ResponseEntity
                .ok()
                .body(shippingRatesService.getByCountry(countryName).stream()
                        .map(country->ShippingRatesMapper.toModel(country))
                        .collect(Collectors.toList()));
    }
}
