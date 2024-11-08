package org.example;

import java.util.ArrayList;
import java.util.List;

class User {
    private String userId;
    private String name;
    private List<Order> orders;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
