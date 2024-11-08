package org.example;

public class Main {
    public static void main(String[] args) {
        // Create a cab booking system
        CabBookingSystem cabBookingSystem = new CabBookingSystem();

        // Add some cabs
        cabBookingSystem.addCab(new Cab(1, new Location(12.9716, 77.5946))); // Bengaluru
        cabBookingSystem.addCab(new Cab(2, new Location(19.0760, 72.8777))); // Mumbai

        // Book a cab
        Location source = new Location(12.9716, 77.5946); // Bengaluru
        Location destination = new Location(13.0827, 80.2707); // Chennai

        int numberOfPassengers = 2;
        Cab bookedCab = cabBookingSystem.bookCab(source, destination, numberOfPassengers);

        if (bookedCab != null) {
            System.out.println("Cab booked successfully!");
            System.out.println("Cab details - ID: " + bookedCab.getId() +
                    ", Location: " + bookedCab.getLocation().getLatitude() + ", " + bookedCab.getLocation().getLongitude());
        } else {
            System.out.println("No cabs available");
        }

    }
}