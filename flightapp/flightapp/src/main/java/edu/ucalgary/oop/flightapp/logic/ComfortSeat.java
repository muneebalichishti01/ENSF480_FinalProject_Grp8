package edu.ucalgary.oop.flightapp.logic;


public class ComfortSeat extends SeatDecorator {
    public ComfortSeat(Seat decoratedSeat) {
        super(decoratedSeat);
    }

    public String getDescription() {
        return super.getDescription() + ", added comfort";
    }

    public double getCost() {
        return super.getCost() + 20.0; // Additional cost for comfort
    }
}
