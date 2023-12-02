package edu.ucalgary.oop.flightapp.logic;

import java.util.ArrayList;
import java.util.Iterator;

public class FlightInfo {
    // Instance variables
    private int flightId;
    private String flightName;
    private String destination;
    private String origin;
    private String departureDate;

    // Added new variables
    private ArrayList<Seat> seats;                                                      // Track seats for this flight
    private static ArrayList<FlightInfo> flightInfoList;                                // Track all flights in the system

    // Constructor
    public FlightInfo(int flightId, String flightName, String destination, String origin, String departureDate) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.destination = destination;
        this.origin = origin;
        this.departureDate = departureDate;

        // Initialize new variables
        this.seats = new ArrayList<>();

        // Initialize ArrayLists
        initializeSeats();        
    }

    // Method to initialize Seats
    private void initializeSeats() {
        for (int i = 0; i < 10; i++) {
            seats.add(new OrdinarySeat(i, false, flightId, 1));                   // Add ordinary seats
            Database.addSeat(seats.get(i));                                                   // Add ordinary seats to database
        }
        for (int i = 10; i < 15; i++) {
            seats.add(new BusinessSeat(new OrdinarySeat(i, false, flightId, 2))); // Add business seats
            Database.addSeat(seats.get(i));                                                   // Add business seats to database
        }
        for (int i = 15; i < 20; i++) {
            seats.add(new ComfortSeat(new OrdinarySeat(i, false, flightId, 3)));  // Add comfort seats
            Database.addSeat(seats.get(i));                                                   // Add comfort seats to database
        }
    }

    // Getters and Setters
    public static FlightInfo getFlightInfoByFlightId(int flightId) {
        return flightInfoList.get(flightId);
    }

    public int getFlightId() {
        return flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    // Getters and setters for the new attributes
    public static ArrayList<FlightInfo> getAllFlightInfo() {
        return flightInfoList;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    // Methods to add or remove FlightInfo to a list of all FlightInfo Objects
    public static void addFlightInfo(FlightInfo flightInfo) {
        flightInfoList.add(flightInfo);
    }
    public static void removeFlightInfo(FlightInfo flightInfo) {
        flightInfoList.remove(flightInfo);
    }

    // Method to initialize system's local storage
    public static void initializeData() {
        flightInfoList = Database.getAllFlights();

        // Getting an iterator for the ArrayList
        Iterator<FlightInfo> iterator = flightInfoList.iterator();

        // Iterating through the ArrayList using iterator
        while (iterator.hasNext()) {
            FlightInfo item = iterator.next();

            item.setSeats(Database.browseSeats(item.getFlightId()));
        }
    }

    // Method to book or unbook seats
    public void setAvailability(int ID) {
        // Getting an iterator for the ArrayList
        Iterator<Seat> iterator = seats.iterator();

        // Iterating through the ArrayList using iterator
        while (iterator.hasNext()) {
            Seat item = iterator.next();
            if(item.getSeatID() == ID) {
                item.setBooked();
            }
            Database.editSeat(item);
        }
    }
}
