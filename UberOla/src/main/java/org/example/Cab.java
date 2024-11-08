package org.example;

class Cab {

    private int id;
    private Location location;
    private boolean isAvailable;

    public Cab(int id, Location location) {
        this.id = id;
        this.location = location;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}