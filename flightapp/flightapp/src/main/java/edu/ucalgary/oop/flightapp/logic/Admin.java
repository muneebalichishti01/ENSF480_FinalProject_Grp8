package edu.ucalgary.oop.flightapp.logic;

import java.util.Map;
import java.util.HashMap;

public class Admin {
    // Instance variables
    private Map<Integer, Aircraft> aircrafts;
    private Map<Integer, FlightInfo> flights;
    private Map<Integer, FlightAttendant> flightAttendants;
    private Map<Integer, User> users;

    // Constructor
    public Admin() {
        this.aircrafts = new HashMap<>();
        this.flights = new HashMap<>();
        this.flightAttendants = new HashMap<>();
        this.users = User.getAllUsers();  // Assuming User class has a method to return all users
    }

    // Getters and Setters
    public Map<Integer, Aircraft> getAircrafts() {
        return aircrafts;
    }
    public Map<Integer, FlightInfo> getFlights() {
        return flights;
    }
    public Map<Integer, FlightAttendant> getFlightAttendants() {
        return flightAttendants;
    }
    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setAircrafts(Map<Integer, Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }
    public void setFlights(Map<Integer, FlightInfo> flights) {
        this.flights = flights;
    }
    public void setFlightAttendants(Map<Integer, FlightAttendant> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }
    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    // Manage Aircrafts
    public void addAircraft(Aircraft aircraft) {
        aircrafts.put(aircraft.getAircraftId(), aircraft);
    }

    public void removeAircraft(int aircraftId) {
        aircrafts.remove(aircraftId);
    }

    public void updateAircraft(int aircraftId, Aircraft updatedAircraft) {
        aircrafts.put(aircraftId, updatedAircraft);
    }

    // Manage Flights
    public void addFlight(FlightInfo flight) {
        flights.put(flight.getFlightId(), flight);
    }

    public void removeFlight(int flightId) {
        flights.remove(flightId);
    }

    public void updateFlight(int flightId, FlightInfo updatedFlight) {
        flights.put(flightId, updatedFlight);
    }

    // Manage Flight Attendants
    public void addFlightAttendant(FlightAttendant attendant) {
        flightAttendants.put(attendant.getFlightAttendantId(), attendant);
    }

    public void removeFlightAttendant(int crewId) {
        flightAttendants.remove(crewId);
    }

    public void updateFlightAttendant(int crewId, FlightAttendant updatedAttendant) {
        flightAttendants.put(crewId, updatedAttendant);
    }

    // Print User Registration List
    public void printUserRegistrationList() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    
}


