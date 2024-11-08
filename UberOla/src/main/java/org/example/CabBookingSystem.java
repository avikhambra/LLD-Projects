package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CabBookingSystem {

    private List<Cab> availableCabs;

    public CabBookingSystem() {
        this.availableCabs = new ArrayList<>();
    }

    public Cab bookCab(Location source, Location destination, int numberOfPassengers) {

        Cab cab = findNearestCab(source);

        if (cab != null) {
            cab.setAvailable(false);
            CabBooking booking = new CabBooking(1, source, destination, numberOfPassengers, cab, new Date());
            return cab;
        } else {
            return null; // No available cabs
        }

    }

    private Cab findNearestCab(Location source) {
        // Logic to find nearest cab
        return availableCabs.get(0); // For simplicity, returning the first cab in the list
    }

    public void addCab(Cab cab) {
        availableCabs.add(cab);
    }

    public void removeCab(Cab cab) {
        availableCabs.remove(cab);
    }
}
