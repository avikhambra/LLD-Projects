// Menu class
class Menu {
    private String itemName;
    private double price;

    public Menu(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    // Getters and setters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}
