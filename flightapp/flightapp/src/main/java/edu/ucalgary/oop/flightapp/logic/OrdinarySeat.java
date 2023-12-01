package edu.ucalgary.oop.flightapp.logic;

public class OrdinarySeat extends Seat {
    // Constructors
    public OrdinarySeat(int ID, boolean booked, int flightID, int type) {
        this.seatID = ID;
        this.booked = booked;
        this.flightID = flightID;
        this.type = type;
    }

    // Getters and Setters
    public String getDescription() {
        return "Ordinary Seat";
    }

    public double getCost() {
        return 50.0; // Base price for an ordinary seat
    }
}
