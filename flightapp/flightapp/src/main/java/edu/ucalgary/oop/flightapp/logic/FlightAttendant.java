package edu.ucalgary.oop.flightapp.logic;


public class FlightAttendant {
    // Instance variables
    private int FlightAttendantId;
    private String username;

    // Constructor
    public FlightAttendant(int FlightAttendantId, String username) {
        this.FlightAttendantId = FlightAttendantId;
        this.username = username;
    }

    // Getters and Setters
    public int getFlightAttendantId() {
        return this.FlightAttendantId;
    }

    public String getUsername() {
        return this.username;
    }
}
