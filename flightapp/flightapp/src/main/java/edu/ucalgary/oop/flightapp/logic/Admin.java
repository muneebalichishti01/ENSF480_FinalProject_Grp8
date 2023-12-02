package edu.ucalgary.oop.flightapp.logic;

import java.util.ArrayList;

public class Admin {
    // Instance variables changed to ArrayLists
    private ArrayList<Aircraft> aircrafts;
    private ArrayList<FlightAttendant> flightAttendants;
    private ArrayList<User> users;

    // Constructor
    public Admin() {
        this.aircrafts = new ArrayList<>();
        this.flightAttendants = new ArrayList<>();
        this.users = new ArrayList<>(User.getAllUsers().values());
    }

    // Getters and Setters
    public ArrayList<Aircraft> getAircrafts() {
        return aircrafts;
    }
    public ArrayList<FlightInfo> getFlights() {
        return FlightInfo.getAllFlightInfo();
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
    public void setFlightAttendants(ArrayList<FlightAttendant> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    // Manage Aircrafts
    public void addAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
        Database.addAircraft(aircraft);
    }
    public void removeAircraft(Aircraft aircraft) {
        aircrafts.remove(aircraft);
        Database.removeAircraft(aircraft.getAircraftId());
    }
    public void updateAircraft(int index, Aircraft updatedAircraft) {
        if (index >= 0 && index < aircrafts.size()) {
            aircrafts.set(index, updatedAircraft);
            Database.editAircraft(updatedAircraft);
        }
    }

    // Manage Flights
    public void addFlight(int flightId, String flightName, String destination, String origin, String departureDate) {
        FlightInfo temp = new FlightInfo(flightId, flightName, destination, origin, departureDate);
    }
    public void removeFlight(FlightInfo flight) {
        FlightInfo.removeFlightInfo(flight);
        Database.removeFlight(flight.getFlightId());
    }
    public void updateFlight(int flightId, String flightName, String destination, String origin, String departureDate, FlightInfo flightInfo) {
        removeFlight(flightInfo);
        FlightInfo temp = new FlightInfo(flightId, flightName, destination, origin, departureDate);
        Database.editFlight(temp);
    }

    // Manage Flight Attendants
    public void addFlightAttendant(FlightAttendant attendant) {
        flightAttendants.add(attendant);
        Database.addFlightAttendant(attendant);
    }
    public void removeFlightAttendant(FlightAttendant attendant) {
        flightAttendants.remove(attendant);
        Database.removeFlightAttendant(attendant.getFlightAttendantId());
    }
    public void updateFlightAttendant(int index, FlightAttendant updatedAttendant) {
        if (index >= 0 && index < flightAttendants.size()) {
            flightAttendants.set(index, updatedAttendant);
            Database.editCrew(updatedAttendant);
        }
    }

    // Print User Registration List
    public void printUserRegistrationList() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
