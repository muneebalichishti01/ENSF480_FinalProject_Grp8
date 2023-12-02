package edu.ucalgary.oop.flightapp.logic;

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
        FlightInfo.addFlightInfo(flight);
        Database.addFlight(flight);
    }
    public void removeFlight(FlightInfo flight) {
        FlightInfo.removeFlightInfo(flight);
        Database.removeFlight(flight.getFlightId());
    }
    public void updateFlight(FlightInfo updFlightInfo) {
        Database.editFlight(updFlightInfo);
    }

    // Manage Flight Attendants
    public void addFlightAttendant(FlightAttendant attendant) {
        Database.addFlightAttendant(attendant);
    }
    public void removeFlightAttendant(FlightAttendant attendant) {
        Database.removeFlightAttendant(attendant.getFlightAttendantId());
    }
<<<<<<< HEAD
    public void updateFlightAttendant(int id, String username) {
        Database.editFlightAttendant(id, username);
=======
    public void updateFlightAttendant(int index) {
        Database.editCrew(index);
>>>>>>> 4ce6f782fea0be7b7c67a2cbe3daa8176d59ec49
    }

    // Print User Registration List
    public void getPassangerList(int flightId) {
        Database.browsePassenger(flightId);
    }
}
