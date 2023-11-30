package edu.ucalgary.oop.flightapp.logic;

import java.util.HashMap;

public class FlightAttendant {
    // Instance variables
    private int FlightAttendantId;
    private String name;
    private String role;

    // Constructor
    public FlightAttendant(int FlightAttendantId, String name, String role) {
        this.FlightAttendantId = FlightAttendantId;
        this.name = name;
        this.role = role; // remove this
    }

    // Getters and Setters
    public int getFlightAttendantId() {
        return FlightAttendantId;
    }
    public void setFlightAttendantId(int FlightAttendantId) {
        this.FlightAttendantId = FlightAttendantId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    // Override toString method to display FlightAttendant information
    @Override
    public String toString() {
        return "FlightAttendant{" +
                "FlightAttendantId=" + FlightAttendantId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    // Hash Map for FlightAttendant
    private static HashMap<Integer, FlightAttendant> FlightAttendantMap = new HashMap<>();

    // Add FlightAttendant member to the HashMap
    public static void addFlightAttendantMember(FlightAttendant FlightAttendant) {
        FlightAttendantMap.put(FlightAttendant.getFlightAttendantId(), FlightAttendant);
    }

    // Get FlightAttendant member by FlightAttendant ID from the HashMap
    public static FlightAttendant getFlightAttendantByFlightAttendantId(int FlightAttendantId) {
        return FlightAttendantMap.get(FlightAttendantId);
    }

    // Get all FlightAttendant members from the HashMap
    public static HashMap<Integer, FlightAttendant> getAllFlightAttendants() {
        return FlightAttendantMap;
    }
}
