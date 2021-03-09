package com.example.SpringMVC.dao.model;

import java.util.List;

public class Order {
    private int orderId;
    private List<Item> item;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
