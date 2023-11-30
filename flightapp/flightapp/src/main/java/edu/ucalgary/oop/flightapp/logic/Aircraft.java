package edu.ucalgary.oop.flightapp.logic;

public class Aircraft {
    // Instance variables
    private int aircraftId;
    private String name;
    // String type is removed

    // Constructors
    public Aircraft(int aircraftId, String name) {
        this.aircraftId = aircraftId;
        this.name = name;
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

    // Override toString method to display aircraft information
    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftId=" + aircraftId +
                ", name='" + name + '\'' +
                '}';
    }

    // Aircraft information is managed through a database rather than in-memory with a HashMap

    /*
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
    */
}
