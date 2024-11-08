package org.example;

import java.util.Date;

class CabBooking {
    private int bookingId;
    private Location source;
    private Location destination;
    private int numberOfPassengers;
    private Cab cab;
    private Date bookingTime;

    public CabBooking(int bookingId, Location source, Location destination, int numberOfPassengers, Cab cab, Date bookingTime) {
        this.bookingId = bookingId;
        this.source = source;
        this.destination = destination;
        this.numberOfPassengers = numberOfPassengers;
        this.cab = cab;
        this.bookingTime = bookingTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public Cab getCab() {
        return cab;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

}
