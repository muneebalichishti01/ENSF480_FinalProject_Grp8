package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import edu.ucalgary.oop.flightapp.logic.Database;
import edu.ucalgary.oop.flightapp.logic.FlightInfo;

public class BrowseFlights extends JFrame {
    private ArrayList<FlightInfo> flights;
    private JTable flightTable;
    private DefaultTableModel tableModel;
    private FlightInfo selectedFlight;

    public BrowseFlights() {
        setTitle("Browse Flights");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] columnNames = {"Flight ID", "Flight Name", "Destination", "Origin", "Departure Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        flightTable = new JTable(tableModel);
        flightTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        flightTable.setAutoCreateRowSorter(true); // Enable sorting

        loadFlights();

        flightTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = flightTable.getSelectedRow();
                if (selectedRow != -1) {
                    selectedFlight = flights.get(flightTable.convertRowIndexToModel(selectedRow));
                }
            }
        });

        add(new JScrollPane(flightTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton bookFlightButton = new JButton("Book Flight");
        bookFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedFlight != null) {
                    FlightBookingPanel bookingPanel = new FlightBookingPanel(selectedFlight);
                    bookingPanel.setVisible(true);
                    dispose(); // Optionally close the BrowseFlights window
                } else {
                    JOptionPane.showMessageDialog(BrowseFlights.this, "Please select a flight first.");
                }
            }
        });
        buttonPanel.add(bookFlightButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window or go back to the previous menu
            }
        });
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadFlights() {
        flights = Database.getAllFlights();
        // flights = Database.getAllFlightsWithSeats();
        for (FlightInfo flight : flights) {
            Object[] row = new Object[]{
                    flight.getFlightId(),
                    flight.getFlightName(),
                    flight.getDestination(),
                    flight.getOrigin(),
                    flight.getDepartureDate()
            };
            tableModel.addRow(row);
        }
    }
}
