package com.kishan.ordermanagement.controller;


import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.kishan.ordermanagement.model.Order;
import com.kishan.ordermanagement.service.ServiceOrder;

@RestController 
@RequestMapping("/order")
public class ControllerOrder {

	@Autowired
	ServiceOrder service;

	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrders() throws Exception {
		List<Order> response   = service.fetchallOrders();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/create")
    public ResponseEntity<Object> createOrder(@RequestBody Order order) throws Exception {
        System.out.println("Order object = " + order.getItem());
        Object response = service.createOrder(order);
        System.out.println("response = " + response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

	@GetMapping("/orderitems/{Id}")
	public ResponseEntity<Object> getAllItems(@PathVariable Integer Id) throws Exception {
		System.out.println("Fetching order .... ");
		Object response = service.getAllDetails(Id);
		return new ResponseEntity<> (response, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteitem/{orderId}/{itemId}")
	public ResponseEntity<String> deleteOrderItem(@PathVariable Integer orderId, @PathVariable Integer itemId) throws Exception {
		System.out.println("Id of the Order from which item is to be deleted = " + orderId);
		System.out.println("Item Id of the deleted item  = " + orderId);
		String response = service.deleteItem(orderId, itemId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
		
	@PostMapping("/additem")
	public ResponseEntity<Object> addItems(@RequestBody Order order) throws Exception {
		
		Order response = service.addItems(order);
		System.out.println("After add items called");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateitem")
	public ResponseEntity<Object> updateOrderItem(@RequestBody Order order) throws Exception {
		
		System.out.println("Updating items in the order " + order.getOrderId());
		Object response = service.updateItem(order);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
}