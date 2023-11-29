package edu.ucalgary.oop.flightapp.logic;

public abstract class SeatDecorator extends Seat {
    protected Seat decoratedSeat;

    public SeatDecorator(Seat decoratedSeat) {
        this.decoratedSeat = decoratedSeat;
    }

    public String getDescription() {
        return decoratedSeat.getDescription();
    }

    public double getCost() {
        return decoratedSeat.getCost();
    }
}
