package edu.ucalgary.oop.flightapp.logic;


public class BusinessSeat extends SeatDecorator {
    public BusinessSeat(Seat decoratedSeat) {
        super(decoratedSeat);
        this.setType(3); // Business seats have type 3

    }

    public String getDescription() {
        return super.getDescription() + ", business class";
    }

    public double getCost() {
        return super.getCost() + 50.0; // Additional cost for business class
    }
}


