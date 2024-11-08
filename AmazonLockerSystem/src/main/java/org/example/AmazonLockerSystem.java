package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class to represent the Amazon Locker System
class AmazonLockerSystem {
    private List<AmazonLocker> lockers;

    public AmazonLockerSystem() {
        this.lockers = new ArrayList<>();
    }

    public void addLocker(AmazonLocker locker) {
        this.lockers.add(locker);
    }

    public List<AmazonLocker> getLockers() {
        return lockers;
    }

    // Method to find the closest available locker to a given location
    public AmazonLocker findClosestLocker(double latitude, double longitude, LockerSize size) {
        // Implementation to find the closest locker
        // This can be done using a location tracking service or algorithms like Dijkstra's algorithm
        // For simplicity, let's assume a random locker is returned
        Random random = new Random();
        return lockers.get(random.nextInt(lockers.size()));
    }

    // Method to assign an order to a locker
    public void assignLocker(Order order, AmazonLocker locker) {
        locker.addOrder(order);
        order.setLocker(locker);
        locker.setStatus(LockerStatus.OCCUPIED);
    }

    // Method to generate a 6-digit code for the locker
    public String generateLockerCode() {
        // Generate a random 6-digit code
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }
}
