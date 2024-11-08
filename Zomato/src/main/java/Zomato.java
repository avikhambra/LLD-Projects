import java.util.*;

// Zomato class
public class Zomato {
    private List<Restaurant> restaurants;
    private List<Order> orders;

    public Zomato() {
        this.restaurants = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    // Method to add a restaurant
    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

    // Method to display restaurants by type
    public List<Restaurant> getRestaurantsByType(RestaurantType type) {
        List<Restaurant> filteredRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getType() == type) {
                filteredRestaurants.add(restaurant);
            }
        }
        return filteredRestaurants;
    }

    // Method to place an order
    public void placeOrder(Order order) {
        this.orders.add(order);
        System.out.println("Order placed successfully!");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("User: " + order.getUser().getName());
        System.out.println("Items:");
        for (Menu item : order.getItems()) {
            System.out.println("- " + item.getItemName() + " - $" + item.getPrice());
        }
        System.out.println("Total Amount: $" + order.getTotalAmount());
    }

    // Method to cancel an order
    public void cancelOrder(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                if (order.getStatus() == OrderStatus.PLACED || order.getStatus() == OrderStatus.CONFIRMED) {
                    order.setStatus(OrderStatus.CANCELLED);
                    System.out.println("Order with ID " + orderId + " has been cancelled.");
                    return;
                } else {
                    System.out.println("Order with ID " + orderId + " cannot be cancelled.");
                    return;
                }
            }
        }
        System.out.println("Order with ID " + orderId + " not found.");
    }


}
