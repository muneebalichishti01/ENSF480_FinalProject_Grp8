package edu.ucalgary.oop.flightapp.logic;

public class BookingInfo {
    // Instance variables
    private int bookingId;
    private FlightInfo flightInfo;
    private double ticketPrice;
    private Seat seat;
    private boolean cancellationInsurance;

    // Constructors
    public BookingInfo(int bookingId, FlightInfo flightInfo, double ticketPrice, Seat seat, boolean cancellationInsurance) {
        this.bookingId = bookingId;
        this.flightInfo = flightInfo;
        this.ticketPrice = ticketPrice;
        this.seat = seat; // optional
        this.cancellationInsurance = cancellationInsurance;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
