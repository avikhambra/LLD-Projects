package org.example;

// Passenger class
public class Passenger extends Person {

    private int passengerID;

    public Passenger(String name, String email, String phone, int passengerID) {
        super(name, email, phone);
        this.passengerID = passengerID;
    }

    public int getPassengerID() {
        return passengerID;
    }

}
