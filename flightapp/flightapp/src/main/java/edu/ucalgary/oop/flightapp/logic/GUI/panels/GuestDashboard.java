package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.stream.Collectors;

import javax.swing.*;

import edu.ucalgary.oop.flightapp.logic.Database;
import edu.ucalgary.oop.flightapp.logic.FlightInfo;
import java.util.List;

import java.awt.*;
import java.awt.event.ActionEvent;

public class GuestDashboard extends JFrame {
  public GuestDashboard() {
    //initializeDatabaseConnection();
    //initialize components and layout for admin dashboard
    setTitle("Guest Dashboard");
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // GridLayout with 5 rows and 1 column, and vertical/horizontal gaps
    JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JLabel welcomeLabel = new JLabel("Welcome to your dashboard! Currently Logged in as Guest", SwingConstants.CENTER);
    panel.add(welcomeLabel);

    // Browsing flights button
    JButton browseFlightsButton = new JButton("Browse Flights");
    browseFlightsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            BrowseFlights browseFlights = new BrowseFlights();
            browseFlights.setVisible(true);
        }
    });
    panel.add(browseFlightsButton);

    JButton cancelFlightButton = new JButton("Cancel Flight");
    cancelFlightButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(GuestDashboard.this, "Enter Booking ID to cancel:");
            if (input != null && !input.isEmpty()) {
                try {
                    int bookingId = Integer.parseInt(input);
                    // FlightInfo temp = FlightInfo.getFlightInfoByFlightId(bookingId); // Error here

                    // Attempt to cancel the booking in the database
                    if (Database.cancelBooking(bookingId)) {
                        // temp.setAvailability(bookingId);                             // Error here
                        JOptionPane.showMessageDialog(GuestDashboard.this, "Booking canceled successfully.");
                    } else {
                        JOptionPane.showMessageDialog(GuestDashboard.this, "Booking ID not found or could not be canceled.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(GuestDashboard.this, "Please enter a valid Booking ID.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Print or log the exception
                    JOptionPane.showMessageDialog(GuestDashboard.this, "A database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });
    panel.add(cancelFlightButton);
    

    // Logout button
    JButton logoutButton = new JButton("Logout");
    logoutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); // Just closes the guest dashboard frame
        }
    });
    panel.add(logoutButton);

    // Back to Login button
    JButton backToLoginButton = new JButton("Back to Login");
    backToLoginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            backToLogin();
        }
    });
    panel.add(backToLoginButton);

    add(panel);
  }
  
//   private void initializeDatabaseConnection() {
//     // Check if connection is already established
//     if (Database.getConnection() == null) {
//         Database.initializeDatabase();
//     }
//   }

  private void backToLogin() {
    LoginPortal loginPortal = new LoginPortal();
    loginPortal.setVisible(true);
    dispose(); // Close the current window
  }



//   private void browseFlights() {
//         try {
//             List<FlightInfo> flights = Database.getAvailableFlights(); // Fetch flights from the database
//             // Display flights in a new window or a dialog
//             // For simplicity, let's just display flight IDs in a message dialog
//             String flightDetails = flights.stream()
//                 .map(flight -> "Flight ID: " + flight.getFlightId() + ", Destination: " + flight.getDestination())
//                 .collect(Collectors.joining("\n"));
//             JOptionPane.showMessageDialog(this, flightDetails);
//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(this, "Error fetching flights: " + ex.getMessage());
//         }
//     }
}
