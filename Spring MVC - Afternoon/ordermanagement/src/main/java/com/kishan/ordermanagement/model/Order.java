package com.kishan.ordermanagement.model;

import java.util.Arrays;

public class Order {

	private Integer orderId;
	private Item[] item;
	
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", item=" + Arrays.toString(item) + "]";
	}

	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public Item[] getItem() {
		return item;
	}
	
	public void setItem(Item[] item) {
		this.item = item;
	}
	
}
