package com.au.OrderManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.OrderManagement.model.Order;
import com.au.OrderManagement.repository.OrderRepository;

@Service
public class OrderService 
{
	@Autowired
	OrderRepository orderrepo;
	
	
	public String addItems(Order order) 
	{
		// TODO Auto-generated method stub
		orderrepo.save(order);
		return "Items are added to Order successfully " + order.getItem_id();
	}

	public List<Order> getItems() 
	{
		// TODO Auto-generated method stub
		return orderrepo.findAll();
	}

	public String deleteItems(String id) 
	{
		// TODO Auto-generated method stub
		orderrepo.deleteById(id);
		return "Your Order deleted successfully";
	}

	public String updateItems(Order order) 
	{
		// TODO Auto-generated method stub
		orderrepo.save(order);
		return "Items list updated successfully " + order.getItem_id();
	}

}
