package org.example;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Creating airline management system
        AirlineManagementSystem airlineManagementSystem = new AirlineManagementSystem();

        // Adding flights
        Flight flight1 = new Flight("FL123", "New York", "Los Angeles", 200, 150.0, 300.0, 500.0, new Date(), new Date());
        Flight flight2 = new Flight("FL456", "Los Angeles", "Chicago", 150, 100.0, 250.0, 400.0, new Date(), new Date());

        airlineManagementSystem.addFlight(flight1);
        airlineManagementSystem.addFlight(flight2);

        // Adding crew
        flight1.addCrew(CrewPosition.PILOT);
        flight1.addCrew(CrewPosition.FLIGHT_ATTENDANT);

        // Adding passengers
        Passenger passenger1 = new Passenger("John Doe", "john@example.com", "1234567890", 1);
        Passenger passenger2 = new Passenger("Monu", "monu@example.com", "9876543210", 2);
        Passenger passenger3 = new Passenger("Avi", "Ak@example.com", "129999890", 7);
        Passenger passenger4 = new Passenger("Sachin", "Sk@example.com", "70823543210", 8);

        airlineManagementSystem.addPassenger(passenger1);
        airlineManagementSystem.addPassenger(passenger2);
        airlineManagementSystem.addPassenger(passenger3);
        airlineManagementSystem.addPassenger(passenger4);

        // Booking flights
        airlineManagementSystem.bookFlight("New York", "Los Angeles", TicketClass.ECONOMY, 1);
        airlineManagementSystem.bookFlight("New York", "Los Angeles", TicketClass.ECONOMY, 7);
        airlineManagementSystem.bookFlight("New York", "Los Angeles", TicketClass.ECONOMY, 8);

        airlineManagementSystem.bookFlight("Los Angeles", "Chicago", TicketClass.FIRST_CLASS, 2);


        // Print manifest
        airlineManagementSystem.printManifest("FL123");

        // Cancel booking
        airlineManagementSystem.cancelBooking("FL123", 1);

        // Print manifest after cancellation
        airlineManagementSystem.printManifest("FL123");

    }
}