package com.kishan.ordermanagement.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kishan.ordermanagement.model.Item;
import com.kishan.ordermanagement.model.Order;

@Service
public class ServiceOrder {
	
	static List<Order> orders = new ArrayList<>();
	
	
	// Creating order using request body
	public static String createOrder(Order order) throws Exception {
		orders.add(order);
		System.out.println("Order created successfully");
		return ("Order created successfully");
	}
	

	// Deleting the Item from the order. Passed order ID and itemId as path params
	public static String deleteItem(Integer requestorderId, Integer requestitemId) throws Exception {
		for(Order order: orders) {
			if(order.getOrderId() == requestorderId) {
				// Using the variable replace index to, replace the requestedItem's index in the order
				// by the next item in the array. This way a particular item will be deleted.
				int replaceindex = 0;
				// Getting the items from each order
				Item[] items = order.getItem();
				
				// Iterating on each item of every order
				for(Item i : items) {
					
					// If the itemId of the particular order matches the requestedItem ID. Stop
					if(i.getItemId() == requestitemId) {
						break;
					}
					replaceindex++;
				}
				
				// After deleting one item, the length of remaining items will be 1 less
				// using updatedItems array to store the current state of order
				Item[] updatedItems = new Item[items.length - 1]; 
				// K is used for iterating on updated items list
		        for (int i = 0, k = 0; i < items.length; i++) { 

		        	// When we reach the replaceIndex we just skip the current Item
		        	// Skipping the item at index replaceindex
		            if (i == replaceindex) { 
		                continue; 
		            } 
		  
		            updatedItems[k++] = items[i]; 
		        } 
		        // Setting the items for the order as updatedItems
		        order.setItem(updatedItems);
		        return "Successfully deleted order "+ requestorderId;
			}
		}
		return "Cannot Delete";
	}

	
	// Adding items to an existing order. Order ID comes in request body
	public static Order addItems(Order temporder) throws Exception {
		for(Order order: orders) {
			if(order.getOrderId() == temporder.getOrderId()) {
				
				Item[] item = order.getItem();
				System.out.println("Inside add item function");
				int newsize = item.length + temporder.getItem().length;
				Item[] updatedlist = new Item[newsize];
				int k = 0;
				for ( int i = 0; i<item.length; i++) {
					Item temp = item[i];
					updatedlist[k++] = temp;
				}
				
				for (int i = 0; i<temporder.getItem().length; i++) {
					Item temp = temporder.getItem()[i];
					updatedlist[k++] = temp;
				}			
				order.setItem(updatedlist);
				return order;
				
			}
		}
		return null;
	}
	

	// Fetching all order details
	public static List<Order> fetchallOrders() throws Exception {
		if (orders.size() == 0) {
			return null;
		}
		return orders;
	}
	
	
	// Updating the order and Item details if the Item exists in the order
	public static Order updateItem(Order temporder) throws Exception {
		for(Order order: orders) {
			if(order.getOrderId() == temporder.getOrderId()) {
				Item[] item = order.getItem();
				int newItemId = temporder.getItem()[0].getItemId(); 
				String newItemName = temporder.getItem()[0].getItemName(); 
				int newItemQuantity = temporder.getItem()[0].getItemQuantity(); 
				
				for(Item i : item) {
					if(i.getItemId() == newItemId) {
						i.setItemName(newItemName);
						i.setItemQuantity(newItemQuantity);
						return order;
					}
				}
			
			}
		}
		return null;
	}
	
	
	// Returning order details for a particular order ID passed in path variables
	public static Order getAllDetails(Integer orderId) throws Exception {
		for(Order order: orders) {
			if(order.getOrderId() == orderId) {
				return order;
			}
		}
		return null;
	}
	
		
}