import java.util.List;

// Restaurant class
class Restaurant {
    private String name;
    private Address address;
    private RestaurantType type;
    private List<Menu> menu;

    public Restaurant(String name, Address address, RestaurantType type, List<Menu> menu) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.menu = menu;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public RestaurantType getType() {
        return type;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public Address getAddress() {
        return address;
    }
}
