package edu.ucalgary.oop.flightapp.logic;

import java.sql.SQLException;

public class Payment {

    // Process payment method
    public BookingInfo processPayment(Seat seat, boolean cancellationInsurance, FlightInfo flightInfo) throws SQLException {
        double price;
        int bookingId = seat.getSeatID() + flightInfo.getFlightId();
        flightInfo.setAvailability(seat.getSeatID());
        if (cancellationInsurance == true) {
            price = seat.getCost() + 50.0;
        }
        price = seat.getCost();
        BookingInfo temp = new BookingInfo(bookingId, flightInfo, price, seat, cancellationInsurance);
        Database.createBooking(temp);
        return temp;
    }
}
