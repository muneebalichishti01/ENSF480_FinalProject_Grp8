package edu.ucalgary.oop.flightapp.logic;

import java.util.HashMap;

public class BookingInfo {
    // Instance variables
    private int bookingId;
    private User user;
    private FlightInfo flightInfo;
    private double ticketPrice;
    private Seat seat; // optional

    // Constructors
    public BookingInfo(int bookingId, User user, FlightInfo flightInfo, double ticketPrice, Seat seat) {
        this.bookingId = bookingId;
        this.user = user;
        this.flightInfo = flightInfo;
        this.ticketPrice = ticketPrice;
        this.seat = seat; // optional
        this.user.setChargeCreditCard(true);
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }
    public void setFlightInfo(FlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    // Optional
    public Seat getSeat() {
        return seat;
    }
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    // Override toString method to display booking information
    @Override
    public String toString() {
        return "BookingInfo{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", flightInfo=" + flightInfo +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    // Hash Map for Booking Information
    private static HashMap<Integer, BookingInfo> bookingInfoMap = new HashMap<>();

    // Add booking information to the HashMap
    public static void addBookingInfo(BookingInfo bookingInfo) {
        bookingInfoMap.put(bookingInfo.getBookingId(), bookingInfo);
    }

    // Get booking information by booking ID from the HashMap
    public static BookingInfo getBookingInfoByBookingId(int bookingId) {
        return bookingInfoMap.get(bookingId);
    }

    // Get all booking information from the HashMap
    public static HashMap<Integer, BookingInfo> getAllBookingInfo() {
        return bookingInfoMap;
    }

    // optional - Get seat type
    public String getSeatType() {
        return seat.getDescription();
    }

    // // Static method to create a new booking
    // public static BookingInfo createBooking(User user, FlightInfo flightInfo, double ticketPrice, String seatType) {
    //     BookingInfo newBooking = new BookingInfo(0, user, flightInfo, ticketPrice);
    //     try {
    //         Database.createBooking(newBooking);
    //         bookingInfoMap.put(newBooking.getBookingId(), newBooking);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return newBooking;
    // }

    // // Static method to cancel a booking
    // public static void cancelBooking(int bookingId) {
    //     try {
    //         Database.cancelBooking(bookingId);
    //         bookingInfoMap.remove(bookingId);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
}
