package edu.ucalgary.oop.flightapp.logic;

import java.util.ArrayList;

public class Admin {
    // Constructor
    public Admin() {
    }

    // Manage Aircrafts
    public void addAircraft(Aircraft aircraft) {
        Database.addAircraft(aircraft);
    }
    public void removeAircraft(Aircraft aircraft) {
        Database.removeAircraft(aircraft.getAircraftId());
    }
    public void updateAircraft(int newID, int oldID) {
        Database.editAircraft(newID, oldID);
    }

    // Manage Flights
    public void addFlight(FlightInfo flight) {
        Database.addFlight(flight);
    }
    public void removeFlight(FlightInfo flight) {
        Database.removeFlight(flight.getFlightId());
    }
    public void updateFlight(int flightId, String flightName, String destination, String origin, String departureDate, FlightInfo flightInfo) {
        FlightInfo temp = new FlightInfo(flightId, flightName, destination, origin, departureDate);
        Database.editFlight(temp);
    }

    // Manage Flight Attendants
    public void addFlightAttendant(FlightAttendant attendant) {
        Database.addFlightAttendant(attendant);
    }
    public void removeFlightAttendant(FlightAttendant attendant) {
        Database.removeFlightAttendant(attendant.getFlightAttendantId());
    }
    public void updateFlightAttendant(int id, String username) {
        Database.editFlightAttendant(id, username);
    }

    // Print User Registration List
    public void getPassangerList(int flightId) {
        Database.browsePassenger(flightId);
    }
}
