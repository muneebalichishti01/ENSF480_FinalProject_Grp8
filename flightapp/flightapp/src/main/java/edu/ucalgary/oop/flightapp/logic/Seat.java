package edu.ucalgary.oop.flightapp.logic;

public abstract class Seat {
    protected int seatID;
    protected boolean booked;
    protected int type;
    protected int flightID;

    // Getters and Setters
    public abstract String getDescription();
    public abstract double getCost();

    // Might mess up needs to be tested
    public int getSeatID() {
        return seatID;
    }
    
    public boolean getBooked() {
        return booked;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getType() {
        return type;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public void setBooked() {
        boolean temp = getBooked();
        if (temp == false) {booked = true;}
        else {booked = false;};
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public void setType(int type) {
        this.type = type;
    }
}

