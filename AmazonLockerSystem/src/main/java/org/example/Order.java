package org.example;

import java.util.Date;

// Class to represent the Order
class Order {
    private String orderId;
    private Date deliveryDate;
    private Date pickupDate;
    private OrderStatus status;
    private String customerPhoneNumber;
    private AmazonLocker locker;

    public Order(String orderId, Date deliveryDate, String customerPhoneNumber) {
        this.orderId = orderId;
        this.deliveryDate = deliveryDate;
        this.customerPhoneNumber = customerPhoneNumber;
        this.status = OrderStatus.DELIVERED;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public AmazonLocker getLocker() {
        return locker;
    }

    public void setLocker(AmazonLocker locker) {
        this.locker = locker;
    }
}
