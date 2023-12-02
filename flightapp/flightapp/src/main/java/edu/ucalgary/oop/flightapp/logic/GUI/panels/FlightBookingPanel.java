package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import edu.ucalgary.oop.flightapp.logic.Database;
import edu.ucalgary.oop.flightapp.logic.FlightInfo;
import edu.ucalgary.oop.flightapp.logic.Seat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FlightBookingPanel extends JFrame {

    private FlightInfo selectedFlight;
    private Seat selectedSeat;

    public FlightBookingPanel(FlightInfo selectedFlight) {
        this.selectedFlight = selectedFlight;
        setTitle("Book Flight: " + selectedFlight.getFlightName());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel seatMapPanel = new JPanel(new GridLayout(0, 4)); // Adjust based on the actual seat layout
        ArrayList<Seat> seats = Database.browseSeats(selectedFlight.getFlightId()); // Fetch seats from the database
        ButtonGroup seatGroup = new ButtonGroup();

        for (Seat seat : seats) {
            JRadioButton seatButton = new JRadioButton("Seat " + seat.getSeatID());
            seatButton.setEnabled(!seat.isBooked()); // Disable if seat is already booked
            seatButton.addActionListener(e -> selectedSeat = seat); // Set selected seat
            seatGroup.add(seatButton);
            seatMapPanel.add(seatButton);
        }

        JButton confirmBookingButton = new JButton("Confirm Booking");
        confirmBookingButton.addActionListener(e -> {
            if (selectedSeat == null) {
                JOptionPane.showMessageDialog(FlightBookingPanel.this, "Please select a seat.");
            } else {
                confirmBooking();
            }
        });

        add(seatMapPanel, BorderLayout.CENTER);
        add(confirmBookingButton, BorderLayout.SOUTH);
    }

    private void confirmBooking() {
        try {
            if (selectedSeat != null) {
                if (selectedSeat.isBooked()) {
                    JOptionPane.showMessageDialog(this, "The selected seat is already booked.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Mark the selected seat as booked in the database
                    selectedSeat.setBooked(true);
                    Database.editSeat(selectedSeat);
    
                    JOptionPane.showMessageDialog(this, "Booking confirmed for seat: " + selectedSeat.getSeatID());
                    dispose(); // Close the panel
    
                    // Transition to PaymentInfoPanel or other appropriate action
                    PaymentInfoPanel paymentInfoPanel = new PaymentInfoPanel(selectedFlight, selectedSeat);
                    paymentInfoPanel.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a seat.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error confirming booking: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
