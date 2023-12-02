package edu.ucalgary.oop.flightapp.logic;


public class ComfortSeat extends SeatDecorator {
    public ComfortSeat(Seat decoratedSeat) {
        super(decoratedSeat);
        this.setType(2); // Comfort seats have type 2
    }

    public String getDescription() {
        return super.getDescription() + ", added comfort";
    }

    public double getCost() {
        return super.getCost() + 20.0; // Additional cost for comfort
    }
}
