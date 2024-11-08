package org.example;

class Order {
    private String orderId;
    private String stockSymbol;
    private OrderType orderType;
    private double price;
    private int quantity;
    private OrderStatus status;

    public Order(String orderId, String stockSymbol, OrderType orderType, double price, int quantity) {
        this.orderId = orderId;
        this.stockSymbol = stockSymbol;
        this.orderType = orderType;
        this.price = price;
        this.quantity = quantity;
        this.status = OrderStatus.PENDING;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
