package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Flight class
public class Flight {

    private String flightNumber;
    private String origin;
    private String destination;
    private int capacity;
    private int seatsLeft;
    private double economyPrice;
    private double businessPrice;
    private double firstClassPrice;
    private Date departureTime;
    private Date arrivalTime;
    private List<Passenger> passengerList;
    private List<CrewPosition> crewList;

    public Flight(String flightNumber, String origin, String destination, int capacity, double economyPrice, double businessPrice, double firstClassPrice, Date departureTime, Date arrivalTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.seatsLeft = capacity;
        this.economyPrice = economyPrice;
        this.businessPrice = businessPrice;
        this.firstClassPrice = firstClassPrice;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.passengerList = new ArrayList<>();
        this.crewList = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public double getBusinessPrice() {
        return businessPrice;
    }

    public double getFirstClassPrice() {
        return firstClassPrice;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public boolean bookSeats(TicketClass ticketClass, Passenger passenger) {

        if (seatsLeft > 0) {
            passengerList.add(passenger);
            seatsLeft--;
            System.out.println("Booking successful for " + passenger.getName() + " on flight " + flightNumber);
            return true;
        } else {
            System.out.println("Sorry, the flight is full.");
            return false;
        }

    }

    public void cancelBooking(Passenger passenger) {

        if (passengerList.contains(passenger)) {
            passengerList.remove(passenger);
            seatsLeft++;
            System.out.println("Booking cancelled for " + passenger.getName() + " on flight " + flightNumber);
        } else {
            System.out.println("Passenger not found on this flight.");
        }

    }

    public void addCrew(CrewPosition position) {
        crewList.add(position);
    }

    public void printManifest() {

        System.out.println("Passenger Manifest for Flight " + flightNumber);
        for (Passenger passenger : passengerList) {
            System.out.println(passenger.getName() + " - " + passenger.getEmail());
        }

        System.out.println("\nCrew List for Flight " + flightNumber);
        for (CrewPosition position : crewList) {
            System.out.println(position);
        }

    }
}
