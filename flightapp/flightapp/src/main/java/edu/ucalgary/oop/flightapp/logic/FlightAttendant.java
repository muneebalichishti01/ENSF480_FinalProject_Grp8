package edu.ucalgary.oop.flightapp.logic;


public class FlightAttendant {
    // Instance variables
    private int FlightAttendantId;
<<<<<<< HEAD
    private String username;
    private String name;

    // Constructor
    public FlightAttendant(int FlightAttendantId, String username, String name) {
        this.FlightAttendantId = FlightAttendantId;
        this.username = username;
=======
    private String name;
    // String role is removed

    // Constructor
    public FlightAttendant(int FlightAttendantId, String name) {
        this.FlightAttendantId = FlightAttendantId;
>>>>>>> 5de12489e70d66c1c38a42d37bedda144fa350cc
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
