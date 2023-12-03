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
    // private User selectedUser;  // User object (for PaymentInfoPanelUser)
    private JComboBox<String> seatTypeComboBox;
    private JPanel seatMapPanel;
    private ButtonGroup seatGroup;
    private static final String ORDINARY_SEAT = "Ordinary";
    private static final String COMFORT_SEAT = "Comfort";
    private static final String BUSINESS_SEAT = "Business";

    public FlightBookingPanel(FlightInfo selectedFlight) {
        this.selectedFlight = selectedFlight;
        setTitle("Book Flight: " + selectedFlight.getFlightName());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Initialize components
        initializeComponents();

        // Add action listener to the combo box
        seatTypeComboBox.addActionListener(e -> updateSeatMap());

        // Initial update of seat map
        updateSeatMap();

        // Layout
        setLayout(new BorderLayout());
        add(seatTypeComboBox, BorderLayout.NORTH);
        add(seatMapPanel, BorderLayout.CENTER);
        add(createControlPanel(), BorderLayout.SOUTH);
    }

    private void initializeComponents() {
        String[] seatTypes = {ORDINARY_SEAT, COMFORT_SEAT, BUSINESS_SEAT};
        seatTypeComboBox = new JComboBox<>(seatTypes);
        seatMapPanel = new JPanel(new GridLayout(0, 4));
        seatGroup = new ButtonGroup();
    }

    private JPanel createControlPanel() {
        JButton confirmBookingButton = new JButton("Confirm Booking");
        confirmBookingButton.addActionListener(e -> confirmBooking());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            BrowseFlights browseFlights = new BrowseFlights();
            browseFlights.setVisible(true);
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(confirmBookingButton);
        controlPanel.add(backButton);
        return controlPanel;
    }

    private void updateSeatMap() {
        seatMapPanel.removeAll();
        seatGroup = new ButtonGroup();
    
        String selectedSeatType = (String) seatTypeComboBox.getSelectedItem();
        ArrayList<Seat> seats = Database.browseSeats(selectedFlight.getFlightId());
    
        for (Seat seat : seats) {
            if (seatTypeMatches(seat, selectedSeatType) && seat.isBooked() == false) {
                JRadioButton seatButton = new JRadioButton("Seat " + seat.getSeatID());
                seatButton.addActionListener(e -> selectedSeat = seat);
                seatGroup.add(seatButton);
                seatMapPanel.add(seatButton);
            }
        }
    
        seatMapPanel.revalidate();
        seatMapPanel.repaint();
    }

    private void confirmBooking() {
        try {
            if (selectedSeat == null) {
                JOptionPane.showMessageDialog(this, "Please select a seat.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Exit if no seat is selected
            }
    
            // // Check if the selected seat is already booked (for safety, in case of concurrent bookings)
            // if (selectedSeat.isBooked() || Database.checkSeatBookedStatus(selectedSeat)) {
            //     JOptionPane.showMessageDialog(this, "The selected seat is already booked.", "Error", JOptionPane.ERROR_MESSAGE);
            //     return; // Exit if the seat is already booked
            // }
    
            // Proceed with booking if the seat is not booked
            selectedSeat.setBooked(true);
            Database.editSeat(selectedSeat);
    
            JOptionPane.showMessageDialog(this, "Booking confirmed for seat: " + selectedSeat.getSeatID());
            dispose(); // Close the panel
    
            // Transition to PaymentInfoPanel or other appropriate action
            PaymentInfoPanel paymentInfoPanel = new PaymentInfoPanel(selectedFlight, selectedSeat);
            paymentInfoPanel.setVisible(true);

            // TODO: Uncomment this section for the User version of the panel
            // Transition to PaymentInfoPanelUser
            // PaymentInfoPanelUser paymentInfoPanelUser = new PaymentInfoPanelUser(selectedFlight, selectedSeat, selectedUser);
            // paymentInfoPanelUser.setVisible(true);
    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error confirming booking: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean seatTypeMatches(Seat seat, String seatType) {
        int seatTypeId = seat.getType(); // Assuming getType() returns an int representing the seat type
        System.out.println("Seat ID: " + seat.getSeatID() + ", Type: " + seatTypeId + ", Booked: " + seat.isBooked()); // Debugging
        // Error here, seat type 1 works, but 2 and 3 don't
        switch (seatType) {
            case ORDINARY_SEAT:
                return seatTypeId == 1; // Assuming 1 represents ordinary seats
            case COMFORT_SEAT:
                return seatTypeId == 2; // Assuming 2 represents comfort seats
            case BUSINESS_SEAT:
                return seatTypeId == 3; // Assuming 3 represents business seats
            default:
                return false;
        }
    }    
    
}
