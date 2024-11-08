package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// AirlineManagementSystem class
public class AirlineManagementSystem {

    private List<Flight> flights;
    private Map<Integer, Passenger> passengers;
    private Map<String, List<Flight>> schedule;

    public AirlineManagementSystem() {
        flights = new ArrayList<>();
        passengers = new HashMap<>();
        schedule = new HashMap<>();
    }

    public void addFlight(Flight flight) {

        flights.add(flight);
        List<Flight> flightList = schedule.getOrDefault(flight.getOrigin() + "-" + flight.getDestination(), new ArrayList<>());
        flightList.add(flight);
        schedule.put(flight.getOrigin() + "-" + flight.getDestination(), flightList);

    }

    public boolean bookFlight(String origin, String destination, TicketClass ticketClass, int passengerID) {

        List<Flight> availableFlights = schedule.getOrDefault(origin + "-" + destination, new ArrayList<>());
        for (Flight flight : availableFlights) {
            if (flight.bookSeats(ticketClass, passengers.get(passengerID))) {
                return true;
            }
        }
        System.out.println("No flights available for the selected route.");
        return false;

    }

    public boolean cancelBooking(String flightNumber, int passengerID) {

        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flight.cancelBooking(passengers.get(passengerID));
                return true;
            }
        }
        System.out.println("Flight not found.");
        return false;

    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getPassengerID(), passenger);
    }

    public void printManifest(String flightNumber) {

        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                flight.printManifest();
                return;
            }
        }
        System.out.println("Flight not found.");

    }
}
