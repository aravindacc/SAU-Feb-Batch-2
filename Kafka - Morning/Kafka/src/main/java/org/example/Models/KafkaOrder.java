package org.example.Models;

public class KafkaOrder {


    private int orderId, quantity, price;
    private String Category;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    @Override
    public String toString() {
        return "KafkaOrder{" +
                "orderId=" + orderId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", Category='" + Category + '\'' +
                '}';
    }
}