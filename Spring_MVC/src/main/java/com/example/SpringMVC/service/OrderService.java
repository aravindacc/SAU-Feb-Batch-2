package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public String createOrder(Order order) {
        orders.add(order);
        return "Order Created Successfully";
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderByID(Integer id) {
        List<Order> orders = getAllOrders();
        for(Order order: orders) {
            if (order.getOrderId() == id) {
                return order;
            }
        }
        return null;
    }

    public void updateOrders(Order order) {
        List<Order> orders = getAllOrders();
        int index = -1;
        for(int i=0;i<orders.size();i++) {
            if (orders.get(i).getOrderId() == order.getOrderId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            orders.set(index, order);
        }
    }
}
