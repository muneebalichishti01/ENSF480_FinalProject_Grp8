package edu.ucalgary.oop.flightapp.logic;


public class FlightAttendant {
    // Instance variables
    private int FlightAttendantId;
    private String username;
    private String name;

    // Constructor
    public FlightAttendant(int FlightAttendantId, String username, String name) {
        this.FlightAttendantId = FlightAttendantId;
        this.username = username;
        this.name = name;
    }

    // Getters and Setters
    public int getFlightAttendantId() {
        return this.FlightAttendantId;
    }

    public String getUsername() {
        return this.name;
    }

    public String getName() {
        return name;
    }
}
