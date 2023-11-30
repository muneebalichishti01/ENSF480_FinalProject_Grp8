package edu.ucalgary.oop.flightapp.logic;

import java.util.ArrayList;

public class Admin {
    // Instance variables changed to ArrayLists
    private ArrayList<Aircraft> aircrafts;
    private ArrayList<FlightInfo> flights;
    private ArrayList<FlightAttendant> flightAttendants;
    private ArrayList<User> users;

    // Constructor
    public Admin() {
        this.aircrafts = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.flightAttendants = new ArrayList<>();
        this.users = new ArrayList<>(User.getAllUsers().values());
    }

    // Getters and Setters
    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }
    public ArrayList<FlightInfo> getFlights() {
        return flights;
    }
    public ArrayList<FlightAttendant> getFlightAttendants() {
        return flightAttendants;
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setAircrafts(ArrayList<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }
    public void setFlights(ArrayList<FlightInfo> flights) {
        this.flights = flights;
    }
    public void setFlightAttendants(ArrayList<FlightAttendant> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    // Manage Aircrafts
    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
        // Database.addAircraft(aircraft); // Uncomment if needed
    }
    public void removeAircraft(Aircraft aircraft) {
        aircrafts.remove(aircraft);
        // Database.removeAircraft(aircraft.getAircraftId()); // Uncomment if needed
    }
    public void updateAircraft(int index, Aircraft updatedAircraft) {
        if (index >= 0 && index < aircrafts.size()) {
            aircrafts.set(index, updatedAircraft);
            // Database.editAircraft(updatedAircraft); // Uncomment if needed
        }
    }

    // Manage Flights
    public void addFlight(FlightInfo flight) {
        flights.add(flight);
        // Database.addFlight(flight); // Uncomment if needed
    }
    public void removeFlight(FlightInfo flight) {
        flights.remove(flight);
        // Database.removeFlight(flight.getFlightId()); // Uncomment if needed
    }
    public void updateFlight(int index, FlightInfo updatedFlight) {
        if (index >= 0 && index < flights.size()) {
            flights.set(index, updatedFlight);
            // Database.editFlight(updatedFlight); // Uncomment if needed
        }
    }

    // Manage Flight Attendants
    public void addFlightAttendant(FlightAttendant attendant) {
        flightAttendants.add(attendant);
        // Database.addFlightAttendant(attendant); // Uncomment if needed
    }
    public void removeFlightAttendant(FlightAttendant attendant) {
        flightAttendants.remove(attendant);
        // Database.removeFlightAttendant(attendant.getFlightAttendantId()); // Uncomment if needed
    }
    public void updateFlightAttendant(int index, FlightAttendant updatedAttendant) {
        if (index >= 0 && index < flightAttendants.size()) {
            flightAttendants.set(index, updatedAttendant);
            // Database.editCrew(updatedAttendant); // Uncomment if needed
        }
    }

    // Print User Registration List
    public void printUserRegistrationList() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
