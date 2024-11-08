package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Class to represent the Amazon Locker
class AmazonLocker {
    private String id;
    private LockerSize size;
    private LockerStatus status;
    private Date lastUpdated;
    private List<Order> orders;

    public AmazonLocker(String id, LockerSize size) {
        this.id = id;
        this.size = size;
        this.status = LockerStatus.AVAILABLE;
        this.lastUpdated = new Date();
        this.orders = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public LockerSize getSize() {
        return size;
    }

    public LockerStatus getStatus() {
        return status;
    }

    public void setStatus(LockerStatus status) {
        this.status = status;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
    }
}
