package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import edu.ucalgary.oop.flightapp.logic.Database;

public class CrewDashboard extends JFrame {
    public CrewDashboard() {
        // Initialize components and layout for the crew dashboard
        setTitle("Crew Dashboard");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Welcome to the crew dashboard", SwingConstants.CENTER);
        panel.add(welcomeLabel);

        // Button for browsing flights
        JButton browseFlightsButton = new JButton("Browse Flights");
        browseFlightsButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              ArrayList<String> availableFlights = Database.retrieveAvailableFlights(); // Method to retrieve available flights
      
              if (!availableFlights.isEmpty()) {
                  String selectedFlight = (String) JOptionPane.showInputDialog(
                          CrewDashboard.this,
                          "Select a Flight:",
                          "Browse Flights",
                          JOptionPane.PLAIN_MESSAGE,
                          null,
                          availableFlights.toArray(),
                          null
                  );
      
                  if (selectedFlight != null) {
                      // Extract only the numeric part of the selectedFlight string
                      String flightIdString = selectedFlight.split(" ")[1].replaceAll("[^\\d]", "");
                      int flightId = Integer.parseInt(flightIdString);
                      
                      // Retrieve passenger list for the selected flight
                      ArrayList<String> passengerList = Database.getPassengersByFlightId(flightId);
      
                      // Display the passenger list in a dialog
                      StringBuilder passengerInfo = new StringBuilder("Passenger List for Flight " + flightId + ":\n");
                      for (String passenger : passengerList) {
                          passengerInfo.append(passenger).append("\n");
                      }
                      JOptionPane.showMessageDialog(CrewDashboard.this, passengerInfo.toString());
                  }
              } else {
                  JOptionPane.showMessageDialog(CrewDashboard.this, "No flights available.");
              }
          }
      });
        panel.add(browseFlightsButton);

        // Log Out button
        JButton logoutButton = new JButton("Log Out");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the CrewDashboard frame
                dispose();
            }
        });
        panel.add(logoutButton);

        // Add the panel to the frame
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CrewDashboard dashboard = new CrewDashboard();
            dashboard.setVisible(true);
        });
    }
}
