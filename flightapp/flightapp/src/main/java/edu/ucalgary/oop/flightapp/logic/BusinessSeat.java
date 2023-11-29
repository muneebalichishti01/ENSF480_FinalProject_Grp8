package edu.ucalgary.oop.flightapp.logic;


public class BusinessSeat extends SeatDecorator {
    public BusinessSeat(Seat decoratedSeat) {
        super(decoratedSeat);
    }

    public String getDescription() {
        return super.getDescription() + ", business class";
    }

    public double getCost() {
        return super.getCost() + 50.0; // Additional cost for business class
    }
}


