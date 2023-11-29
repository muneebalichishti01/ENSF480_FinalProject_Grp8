package edu.ucalgary.oop.flightapp.logic;

public class OrdinarySeat extends Seat {
    public String getDescription() {
        return "Ordinary Seat";
    }

    public double getCost() {
        return 50.0; // Base price for an ordinary seat
    }
}
