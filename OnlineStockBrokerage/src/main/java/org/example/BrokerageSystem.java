package org.example;

import java.util.HashMap;
import java.util.Map;

class BrokerageSystem {

    private Map<String, User> users;
    private Map<String, Stock> stocks;

    public BrokerageSystem() {
        this.users = new HashMap<>();
        this.stocks = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public void executeOrder(Order order) {
        Stock stock = stocks.get(order.getStockSymbol());
        if (stock == null) {
            System.out.println("Stock not found");
            return;
        }

        if (order.getOrderType() == OrderType.BUY) {
            if (stock.getQuantity() >= order.getQuantity()) {
                stock.setQuantity(stock.getQuantity() - order.getQuantity());
                order.setStatus(OrderStatus.EXECUTED);
                System.out.println("Order ID: " + order.getOrderId() + " executed successfully");
            } else {
                order.setStatus(OrderStatus.CANCELLED);
                System.out.println("Order ID: " + order.getOrderId() + " cancelled. Insufficient stock");
            }
        } else {
            stock.setQuantity(stock.getQuantity() + order.getQuantity());
            order.setStatus(OrderStatus.EXECUTED);
            System.out.println("Order ID: " + order.getOrderId() + " executed successfully");
        }
    }

    // Getters and Setters
    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Stock> getStocks() {
        return stocks;
    }
}
