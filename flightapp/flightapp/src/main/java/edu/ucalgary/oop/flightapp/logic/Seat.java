package edu.ucalgary.oop.flightapp.logic;

public abstract class Seat {
    protected int seatID;
    protected int booked;
    protected int type;
    protected int flightID;

    public abstract String getDescription();
    public abstract double getCost();
}

