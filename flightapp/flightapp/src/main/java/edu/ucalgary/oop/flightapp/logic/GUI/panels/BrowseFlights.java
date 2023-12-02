package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import edu.ucalgary.oop.flightapp.logic.Database;
import edu.ucalgary.oop.flightapp.logic.FlightInfo;
import edu.ucalgary.oop.flightapp.logic.Seat;

public class BrowseFlights extends JFrame {

    private FlightInfo selectedFlight;

    public BrowseFlights() {
        setTitle("Browse Flights");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel selectLabel = new JLabel("Select a Flight:", SwingConstants.CENTER);
        panel.add(selectLabel);

        ButtonGroup buttonGroup = new ButtonGroup();

        ArrayList<FlightInfo> temp = Database.getAllFlights();

        // Display available flights as radio buttons
        for (FlightInfo flight : temp) {
            JRadioButton radioButton = new JRadioButton(
                "Flight ID: " + flight.getFlightId() + " | Destination: " + flight.getDestination() + " | Departure: " + flight.getDepartureDate());
            radioButton.setActionCommand(String.valueOf(flight.getFlightId()));
            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedFlight = flight;
                    displaySeatMap();
                }
            });
            buttonGroup.add(radioButton);
            panel.add(radioButton);
        }

        add(panel);
    }

    private void displaySeatMap() {
        setTitle("Seat Map for Flight " + selectedFlight.getFlightId());
        getContentPane().removeAll();

        JPanel seatPanel = new JPanel(new GridLayout(4, 5, 10, 10));
        seatPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Get seat information for the selected flight
        for (Seat seat : selectedFlight.getSeats()) {
            JButton seatButton = new JButton("Seat " + seat.getSeatID());
            if (seat.getBooked()) {
                seatButton.setBackground(Color.RED); // Booked seat
                seatButton.setEnabled(false); // Disable booking for this seat
            } else {
                seatButton.setBackground(Color.GREEN); // Available seat
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Implement the action when the user selects a seat
                        JOptionPane.showMessageDialog(BrowseFlights.this, "You selected Seat " + seat.getSeatID());
                    }
                });
            }
            seatPanel.add(seatButton);
        }

        add(seatPanel);
        revalidate();
        repaint();
    }
}
