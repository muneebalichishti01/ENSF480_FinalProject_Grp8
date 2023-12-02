package edu.ucalgary.oop.flightapp.logic.ARCHIVED;
//remove this file
import java.util.HashMap;
import java.util.Map;

import edu.ucalgary.oop.flightapp.logic.BookingInfo;

public class PassengerList {
    // Instance variables
    private int flightId;
    private Map<Integer, BookingInfo> passengerBookings; // Maps user ID to BookingInfo

    // Constructor
    public PassengerList(int flightId) {
        this.flightId = flightId;
        this.passengerBookings = new HashMap<>();
    }

    // Add a passenger's booking to the list
    // public void addPassengerBooking(BookingInfo booking) {
    //     if (booking.getFlightInfo().getFlightId() == this.flightId) {
    //         passengerBookings.put(booking.getUser().getUserId(), booking);
    //     }
    // }

    // Remove a passenger's booking from the list
    public void removePassengerBooking(int userId) {
        passengerBookings.remove(userId);
    }

    // Get BookingInfo for a specific passenger
    public BookingInfo getPassengerBooking(int userId) {
        return passengerBookings.get(userId);
    }

    // Print passenger list with booking details
    public void printPassengerList() {
        System.out.println("Passenger List for Flight ID " + flightId + ":");
        for (BookingInfo booking : passengerBookings.values()) {
            System.out.println("User ID: " + booking.getUser().getUserId() + ", Name: " + booking.getUser().getUsername());
        }
    }

    // Getters and Setters
    public int getFlightId() {
        return flightId;
    }
    
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}
