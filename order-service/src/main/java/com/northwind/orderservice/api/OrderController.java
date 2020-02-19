package com.northwind.orderservice.api;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.northwind.orderservice.domain.Order;
import com.northwind.orderservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/orderhistory/{customerNo}")
    public ResponseEntity<List<OrderModel>> get(@PathVariable String customerNo){
        List<Order> orders = service.getCustomerByNo(customerNo);

        if(orders.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<OrderModel> orderModels = orders.stream()
                .map(o->OrderMapper.toModel(o))
                .collect(Collectors.toList());

        return ResponseEntity.ok(orderModels);
    }


    @GetMapping
    public ResponseEntity<List<OrderModel>> get(
            @RequestParam(required = false)Optional<Integer> offset,
            @RequestParam(required = false)Optional<Integer> limit) {

        List<OrderModel> orders = service.getAll(offset.orElse(0), limit.orElse(10))
                .stream().map(o->OrderMapper.toModel(o))
                .collect(Collectors.toList());

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderNo}")
    public ResponseEntity<OrderModel> get(@PathVariable long orderNo) {
        Optional<Order> order = service.get(orderNo);
        if (!order.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(OrderMapper.toModel(order.get()));
    }

    @PostMapping
    public ResponseEntity<OrderModel> create(@RequestBody OrderModel model) {
        if (model.getItems() == null || model.getItems().size() == 0) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Order order = OrderMapper.toNewEntity(model);

        OrderModel savedOrder =
                OrderMapper.toModel(service.save(order));

        return ResponseEntity.created(URI.create("/orders/" + order.getId()))
                .body(savedOrder);
    }

    @PutMapping("/{orderNo}")
    public ResponseEntity<OrderModel> update(@PathVariable long orderNo, @RequestBody OrderModel model) {
        Optional<Order> order = service.get(orderNo);
        if (!(order.isPresent()))
            return ResponseEntity.notFound().build();

        if (order.get().getVersion() != model.getVersion())
            return new ResponseEntity<>(OrderMapper.toModel(order.get()), HttpStatus.CONFLICT);

        OrderMapper.merge(model, order.get());
        return ResponseEntity.ok(OrderMapper.toModel(service.save(order.get())));
    }

    @DeleteMapping("/{orderNo}")
    public ResponseEntity delete(@PathVariable long orderNo) {
        service.delete(orderNo);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping
//    public ResponseEntity<List<OrderModel>> get(@RequestParam long customerId, @RequestParam java.sql.Date startDate, @RequestParam Date endDate){
//        List<Order> orders = service.getByDate(customerId,startDate,endDate);
//        List<OrderModel> orderModels = orders.stream()
//                                        .map(o->OrderMapper.toModel(o))
//                                        .collect(Collectors.toList());
//        return ResponseEntity.ok(orderModels);
//    }
}
