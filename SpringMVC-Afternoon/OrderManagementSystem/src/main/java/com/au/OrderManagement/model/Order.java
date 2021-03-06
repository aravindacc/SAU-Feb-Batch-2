package com.au.OrderManagement.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "order")
public class Order 
{
	@Id
	private String id;
	private int customer_id;
	private String item_id;
	private int quantity;
	private int price;
	public Order() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, int customer_id, String item_id, int quantity, int price) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.price = price;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", customer_id=" + customer_id + ", item_id=" + item_id + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
	
	
	
}
