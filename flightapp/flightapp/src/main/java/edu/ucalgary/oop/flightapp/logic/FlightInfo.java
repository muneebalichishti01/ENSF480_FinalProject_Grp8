package edu.ucalgary.oop.flightapp.logic;

import java.util.ArrayList;
import java.util.HashMap;

public class FlightInfo {
    // Instance variables
    private int flightId;
    private String flightName;
    private String destination;
    private String origin;
    private String departureDate;

    // Added new variables
    private ArrayList<BookingInfo> passengerBookings;   // Track passengers for this flight
    private ArrayList<Seat> seat;                       // Track seats for this flight
    private ArrayList<FlightAttendant> flightAttendant; // Track flight attendants for this flight

    // Constructor
    public FlightInfo(int flightId, String flightName, String destination, String origin, String departureDate) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.destination = destination;
        this.origin = origin;
        this.departureDate = departureDate;

        // Initialize new variables
        this.passengerBookings = new ArrayList<>();
        this.seat = new ArrayList<>();
        this.flightAttendant = new ArrayList<>();

        // Initialize seats for this flight
        initializeSeats();
    }

    // Method to initialize Seats
    private void initializeSeats() {
        for (int i = 0; i < 10; i++) {
            seat.add(new OrdinarySeat(i, false, flightId, 1));                   // Add ordinary seats
        }
        for (int i = 10; i < 15; i++) {
            seat.add(new BusinessSeat(new OrdinarySeat(i, false, flightId, 2))); // Add business seats
        }
        for (int i = 15; i < 20; i++) {
            seat.add(new ComfortSeat(new OrdinarySeat(i, false, flightId, 3)));  // Add comfort seats
        }
    }

    // Getters and Setters
    public int getFlightId() {
        return flightId;
    }
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDepartureDate() {
        return departureDate;
    }
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    // Getters and setters for the new attributes
    public ArrayList<BookingInfo> getPassengerBookings() {
        return passengerBookings;
    }
    public void setPassengerBookings(ArrayList<BookingInfo> passengerBookings) {
        this.passengerBookings = passengerBookings;
    }

    public ArrayList<Seat> getSeat() {
        return seat;
    }
    public void setSeat(ArrayList<Seat> seat) {
        this.seat = seat;
    }

    public ArrayList<FlightAttendant> getFlightAttendant() {
        return flightAttendant;
    }
    public void setFlightAttendant(ArrayList<FlightAttendant> flightAttendant) {
        this.flightAttendant = flightAttendant;
    }

    // Methods to add or remove a booking to the flight
    public void addBooking(BookingInfo booking) {
        if (booking != null && booking.getFlightInfo().getFlightId() == this.flightId) {
            passengerBookings.add(booking);
        }
    }
    public void removeBooking(BookingInfo booking) {
        passengerBookings.remove(booking);
    }

    // Override toString method to display flight information
    @Override
    public String toString() {
        return "FlightInfo{" +
                "flightId=" + flightId +
                ", flightName='" + flightName + '\'' +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", passengerBookings=" + passengerBookings +
                '}';
    }

    // Static methods for flight info map
    private static HashMap<Integer, FlightInfo> flightInfoMap = new HashMap<>();

    public static void addFlightInfo(FlightInfo flightInfo) {
        flightInfoMap.put(flightInfo.getFlightId(), flightInfo);
    }

    public static FlightInfo getFlightInfoByFlightId(int flightId) {
        return flightInfoMap.get(flightId);
    }

    public static HashMap<Integer, FlightInfo> getAllFlightInfo() {
        return flightInfoMap;
    }
}
