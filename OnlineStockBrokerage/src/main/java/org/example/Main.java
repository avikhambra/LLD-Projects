package org.example;

public class Main {
    public static void main(String[] args) {
        BrokerageSystem brokerageSystem = new BrokerageSystem();

        User user1 = new User("1", "Alice");
        User user2 = new User("2", "Bob");

        Stock stock1 = new Stock("AAPL", 150.0, 100);
        Stock stock2 = new Stock("GOOG", 2500.0, 50);

        brokerageSystem.addUser(user1);
        brokerageSystem.addUser(user2);

        brokerageSystem.addStock(stock1);
        brokerageSystem.addStock(stock2);

        Order order1 = new Order("1", "AAPL", OrderType.BUY, 150.0, 10);
        Order order2 = new Order("2", "GOOG", OrderType.SELL, 2500.0, 5);

        user1.placeOrder(order1);
        user2.placeOrder(order2);

        System.out.println("User: " + user1.getName());
        System.out.println("Orders:");
        for (Order order : user1.getOrders()) {
            System.out.println("Order ID: " + order.getOrderId() + ", Stock Symbol: " + order.getStockSymbol() +
                    ", Order Type: " + order.getOrderType() + ", Quantity: " + order.getQuantity());
        }

        System.out.println("\nUser: " + user2.getName());
        System.out.println("Orders:");
        for (Order order : user2.getOrders()) {
            System.out.println("Order ID: " + order.getOrderId() + ", Stock Symbol: " + order.getStockSymbol() +
                    ", Order Type: " + order.getOrderType() + ", Quantity: " + order.getQuantity());
        }

        brokerageSystem.executeOrder(order1);
        brokerageSystem.executeOrder(order2);

        System.out.println("\nStocks after execution:");
        for (Stock stock : brokerageSystem.getStocks().values()) {
            System.out.println("Stock Symbol: " + stock.getSymbol() + ", Quantity: " + stock.getQuantity());
        }
    }
}