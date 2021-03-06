package org.example.Controller;



import org.example.Models.KafkaOrder;
import org.example.Services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@Slf4j

public class KafkaController {
    @Autowired
    private KafkaProducerService producerService;
    private List<KafkaOrder> orders = new ArrayList<>();

    @PostMapping(value = "/placeorder")
    public ResponseEntity<KafkaOrder> produceNewOrder(@RequestBody KafkaOrder order) {
        System.out.println(order.toString());
        producerService.createOrder(order);
        orders.add(order);
        return new ResponseEntity(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/deliver/{orderId}")
    public ResponseEntity<KafkaOrder> produceNewShippingOrder(@PathVariable(name = "orderId") int orderId) {
        for (int i = 0; i<orders.size(); i++) {
            if (orderId == (orders.get(i)).getOrderId()) {
                producerService.shipOrder(orders.get(i));
                KafkaOrder temporder = orders.get(i);
                orders.remove(i);
                return new ResponseEntity<>(temporder, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}