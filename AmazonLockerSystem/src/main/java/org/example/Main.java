package org.example;

import org.example.AmazonLocker;
import org.example.AmazonLockerSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Amazon Locker System
        AmazonLockerSystem system = new AmazonLockerSystem();

        // Create some Amazon lockers
        AmazonLocker locker1 = new AmazonLocker("Locker1", LockerSize.SMALL);
        AmazonLocker locker2 = new AmazonLocker("Locker2", LockerSize.MEDIUM);
        AmazonLocker locker3 = new AmazonLocker("Locker3", LockerSize.LARGE);

        // Add lockers to the system
        system.addLocker(locker1);
        system.addLocker(locker2);
        system.addLocker(locker3);

        // Simulate an order
        Order order1 = new Order("Order1", new Date(), "1234567890");
        AmazonLocker closestLocker = system.findClosestLocker(37.7749, -122.4194, LockerSize.SMALL);
        system.assignLocker(order1, closestLocker);

        // Generate locker code and send it to the customer
        String lockerCode = system.generateLockerCode();
        System.out.println("Locker code for Order1: " + lockerCode);
    }
}