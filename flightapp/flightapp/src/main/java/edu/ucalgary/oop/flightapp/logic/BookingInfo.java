package edu.ucalgary.oop.flightapp.logic;

public class BookingInfo {
    // Instance variables
    private int bookingId;
    private User user;
    private int flightId;
    private double ticketPrice;
    private Seat seat; // optional

    // Constructors
    public BookingInfo(int bookingId, User user, FlightInfo flightInfo, double ticketPrice, Seat seat) {
        this.bookingId = bookingId;
        this.user = user;
        this.flightId = flightInfo.getFlightId();
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

    // optional - Get seat type
    public String getSeatType() {
        return seat.getDescription();
    }

    public void useCompanionTicket() {
        if (user instanceof RegisteredUser) {
            user.useCompanionTicket();
        }
    }

}
