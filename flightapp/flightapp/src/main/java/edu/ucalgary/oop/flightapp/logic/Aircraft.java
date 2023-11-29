package edu.ucalgary.oop.flightapp.logic;

import java.util.HashMap;

public class Aircraft {
    // Attributes
    private int aircraftId;
    private String name;
    private String type;

    // Constructors
    public Aircraft(int aircraftId, String name, String type) {
        this.aircraftId = aircraftId;
        this.name = name;
        this.type = type;
    }

    // Getters and Setters
    public int getAircraftId() {
        return aircraftId;
    }
    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    // Override toString method to display aircraft information
    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftId=" + aircraftId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    // Hash Map for Aircraft Information
    private static HashMap<Integer, Aircraft> aircraftMap = new HashMap<>();

    // Add aircraft information to the HashMap
    public static void addAircraft(Aircraft aircraft) {
        aircraftMap.put(aircraft.getAircraftId(), aircraft);
    }

    // Get aircraft information by aircraft ID from the HashMap
    public static Aircraft getAircraftById(int aircraftId) {
        return aircraftMap.get(aircraftId);
    }

    // Get all aircraft information from the HashMap
    public static HashMap<Integer, Aircraft> getAllAircraft() {
        return aircraftMap;
    }
}
