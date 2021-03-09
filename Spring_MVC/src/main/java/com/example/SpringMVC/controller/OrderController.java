package com.example.SpringMVC.controller;

import com.example.SpringMVC.dao.model.Item;
import com.example.SpringMVC.dao.model.Order;
import com.example.SpringMVC.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    // Get All Orders
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    // Create Order
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    // Add Item to Order
    @PostMapping("/{id}/item")
    public ResponseEntity<Order> addItemToOrder(@PathVariable Integer id, @RequestBody Item item) {
        Order order = orderService.getOrderByID(id);
        if (order != null) {
            List<Item> items = order.getItem();
            items.add(item);
            order.setItem(items);
            orderService.updateOrders(order);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new Order(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/item")
    public ResponseEntity<List<Item>> getAllItems(@PathVariable Integer id) {
        Order order = orderService.getOrderByID(id);
        if (order != null) {
            return new ResponseEntity<>(order.getItem(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}/item/{item_id}")
    public ResponseEntity<Item> updateItem(@PathVariable Integer id, @PathVariable Integer item_id,
                                           @RequestBody Item item) {
        Order order = orderService.getOrderByID(id);
        int item_index = -1;
        if (order != null) {
            List<Item> items = order.getItem();
            for(int i=0;i<items.size();i++) {
                if (items.get(i).getItemId() == item_id) {
                    item_index = i;
                    break;
                }
            }
            if (item_index != -1) {
                items.set(item_index, item);
                order.setItem(items);
                orderService.updateOrders(order);
            }
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Item(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}/item/{item_id}")
    public ResponseEntity<String> deleteItem(@PathVariable Integer id, @PathVariable Integer item_id) {
        Order order = orderService.getOrderByID(id);
        List<Item> items = order.getItem();
        int index = -1;
        for(int i=0;i<items.size();i++) {
            if (items.get(i).getItemId() == item_id) {
                index = i;
            }
        }
        if (index != -1) {
            items.remove(index);
            order.setItem(items);
            orderService.updateOrders(order);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
