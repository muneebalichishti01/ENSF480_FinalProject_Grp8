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

        ArrayList<Seat> seats = Database.browseSeats(selectedFlight.getFlightId()); // Fetch seats from the database
        JPanel seatMapPanel = new JPanel(new GridLayout(0, 4)); // Adjust based on the actual seat layout
        ButtonGroup seatGroup = new ButtonGroup();

        for (Seat seat : seats) {
            JRadioButton seatButton = new JRadioButton("Seat " + seat.getSeatID());
            seatButton.setEnabled(!seat.isBooked()); // Disable if seat is already booked
            seatButton.addActionListener(e -> selectedSeat = seat); // Set selected seat
            seatGroup.add(seatButton);
            seatMapPanel.add(seatButton);
        }

        // Check if there are no seats available and show a message
        if (seats.isEmpty()) {
            JOptionPane.showMessageDialog(this, "There are no seats available for this flight.", "No Seats Available", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the panel if no seats are available
        }
        
        JButton confirmBookingButton = new JButton("Confirm Booking");
        confirmBookingButton.addActionListener(e -> {
            if (selectedSeat == null) {
                JOptionPane.showMessageDialog(FlightBookingPanel.this, "Please select a seat.");
            } else {
                confirmBooking();
            }
        });

        // Create a back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            // Close the current window
            dispose();
            // Open the BrowseFlights panel only if seats are available
            if (!seats.isEmpty()) {
                BrowseFlights browseFlights = new BrowseFlights();
                browseFlights.setVisible(true);
            }
        });

        // Add the buttons to the bottom of the panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(confirmBookingButton);
        bottomPanel.add(backButton);
        add(seatMapPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
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
