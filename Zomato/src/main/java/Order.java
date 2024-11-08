import java.util.List;

// Order class
class Order {
    private int orderId;
    private User user;
    private List<Menu> items;
    private OrderStatus status;
    private double totalAmount;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Menu> getItems() {
        return items;
    }

    public void setItems(List<Menu> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Order(int orderId, User user, List<Menu> items, OrderStatus status, double totalAmount) {
        this.orderId = orderId;
        this.user = user;
        this.items = items;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }
}
