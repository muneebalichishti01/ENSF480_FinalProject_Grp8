package edu.ucalgary.oop.flightapp.logic;


public class FlightAttendant {
    // Instance variables
    private int FlightAttendantId;
    private String name;
    // String role is removed

    // Constructor
    public FlightAttendant(int FlightAttendantId, String name) {
        this.FlightAttendantId = FlightAttendantId;
        this.name = name;
    }

    // Getters and Setters
    public int getFlightAttendantId() {
        return FlightAttendantId;
    }

    public String getName() {
        return name;
    }
}
