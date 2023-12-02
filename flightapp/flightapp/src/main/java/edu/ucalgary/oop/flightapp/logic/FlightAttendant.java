package edu.ucalgary.oop.flightapp.logic;


public class FlightAttendant {
    // Instance variables
    private int FlightAttendantId;
<<<<<<< HEAD
    private String username;

    // Constructor
    public FlightAttendant(int FlightAttendantId, String username) {
        this.FlightAttendantId = FlightAttendantId;
        this.username = username;
=======
    private String name;
    // String role is removed

    // Constructor
    public FlightAttendant(int FlightAttendantId, String name) {
        this.FlightAttendantId = FlightAttendantId;
        this.name = name;
>>>>>>> 4ce6f782fea0be7b7c67a2cbe3daa8176d59ec49
    }

    // Getters and Setters
    public int getFlightAttendantId() {
        return this.FlightAttendantId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getName() {
        return name;
    }
}
