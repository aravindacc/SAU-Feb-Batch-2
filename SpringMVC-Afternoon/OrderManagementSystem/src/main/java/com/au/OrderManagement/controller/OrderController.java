package com.au.OrderManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.OrderManagement.model.Order;
import com.au.OrderManagement.service.OrderService;

@RestController
public class OrderController 
{
	@Autowired
	OrderService orderService;
	
	
	
		//order table is automatically created when we post or add items
	
		//AddItems method for the API Request to get
		@PostMapping("/addItems")
		public String addItems(@RequestBody Order order)
		{
			return orderService.addItems(order);
		}
		
		//AddItems method for the API Request to get
		@PutMapping("/updateItems")
		public String updateItems(@RequestBody Order order)
		{
			return orderService.updateItems(order);
		}
				
		// getItems method for the API Request to get
		@GetMapping("/getItems")
		public List<Order> getItems( )
		{
			return orderService.getItems();
		}
		
		// deleteItems method for the API Request to delete
		@DeleteMapping("/deleteItems/'{id}'")
		public String deleteItems(@PathVariable String id)
		{
			return orderService.deleteItems(id);
		}
		
		
		

	
}
