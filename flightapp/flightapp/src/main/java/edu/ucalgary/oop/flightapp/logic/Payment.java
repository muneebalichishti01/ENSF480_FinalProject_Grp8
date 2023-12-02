package edu.ucalgary.oop.flightapp.logic;

import java.sql.SQLException;

public class Payment {
    // Instance variables
    private Seat seat;
    private boolean cancellationInsurance;

    // Constructor
    public Payment(Seat seat, boolean cancellationInsurance) {
        this.seat = seat;
        this.cancellationInsurance = cancellationInsurance;
    }

    // Getters and Setters
    public Seat getSeat() {
        return seat;
    }

    public boolean getCancellationInsurance() {
        return cancellationInsurance;
    }

    // Process payment method
    public BookingInfo processPayment(FlightInfo flightInfo) throws SQLException {
        double price;
        flightInfo.setAvailability(seat.getSeatID());
        if (cancellationInsurance == true) {
            price = seat.getCost() + 50.0;
        }
        price = seat.getCost();
        int bookingId = seat.getSeatID() + flightInfo.getFlightId();
        BookingInfo temp = new BookingInfo(bookingId, flightInfo, price, seat, cancellationInsurance);
        Database.createBooking(temp);
        return temp;
    }
}
