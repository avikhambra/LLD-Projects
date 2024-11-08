import java.util.ArrayList;
import java.util.List;

public class Main {

    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        // Creating users
        User user1 = new User("John Doe", "john.doe@example.com", "+1234567890");
        User user2 = new User("Jane Smith", "jane.smith@example.com", "+1987654321");

        // Creating addresses
        Address address1 = new Address("123 Main St", "Anytown", "Anystate", "12345");
        Address address2 = new Address("456 Elm St", "Othertown", "Otherstate", "67890");

        // Creating menus
        Menu menu1 = new Menu("Paneer Tikka", 10.99);
        Menu menu2 = new Menu("Chicken Fried Rice", 8.99);
        Menu menu3 = new Menu("Margherita Pizza", 12.99);
        Menu menu4 = new Menu("Tacos", 7.99);

        // Creating restaurants
        List<Menu> restaurant1Menu = new ArrayList<>();
        restaurant1Menu.add(menu1);
        restaurant1Menu.add(menu2);
        Restaurant restaurant1 = new Restaurant("Spice Village", address1, RestaurantType.INDIAN, restaurant1Menu);

        List<Menu> restaurant2Menu = new ArrayList<>();
        restaurant2Menu.add(menu3);
        restaurant2Menu.add(menu4);
        Restaurant restaurant2 = new Restaurant("Pizza World", address2, RestaurantType.ITALIAN, restaurant2Menu);

        // Creating Zomato instance
        Zomato zomato = new Zomato();
        zomato.addRestaurant(restaurant1);
        zomato.addRestaurant(restaurant2);

        // Displaying Indian restaurants
        System.out.println("Indian Restaurants:");
        List<Restaurant> indianRestaurants = zomato.getRestaurantsByType(RestaurantType.INDIAN);
        for (Restaurant restaurant : indianRestaurants) {
            System.out.println(restaurant.getName());
            System.out.println("Menu:");
            for (Menu menu : restaurant.getMenu()) {
                System.out.println(menu.getItemName() + " - $" + menu.getPrice());
            }
        }

        // Placing an order
        List<Menu> orderItems = new ArrayList<>();
        orderItems.add(menu1);
        orderItems.add(menu2);
        Order order = new Order(1, user1, orderItems, OrderStatus.PLACED, menu1.getPrice() + menu2.getPrice());
        zomato.placeOrder(order);

        // Canceling an order
        zomato.cancelOrder(order.getOrderId());
    }

}
