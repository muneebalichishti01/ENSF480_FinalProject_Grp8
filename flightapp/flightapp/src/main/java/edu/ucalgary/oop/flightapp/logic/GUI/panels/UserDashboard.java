package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import edu.ucalgary.oop.flightapp.logic.Database;
import edu.ucalgary.oop.flightapp.logic.User; // Import the User class
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class UserDashboard extends JFrame {
    private User currentUser;

    public UserDashboard(User currentUser) {
        this.currentUser = currentUser;

        setTitle("User Dashboard - " + currentUser.getUsername()); // Display username in title
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel welcomeLabel = new JLabel("Welcome to your dashboard, " + currentUser.getUsername() + "!");
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        JButton browseFlightsButton = createButton("Browse Flights", e -> openBrowseFlights());
        buttonsPanel.add(browseFlightsButton);

        JButton cancelFlightButton = createButton("Cancel Flight", e -> {
          try {
            cancelFlight();
          } catch (SQLException e1) {
            e1.printStackTrace();
          }
        });
        buttonsPanel.add(cancelFlightButton);

        JButton applyCreditCardButton = createButton("Apply for Credit Card", e -> applyForCreditCard());
        buttonsPanel.add(applyCreditCardButton);

        JButton logoutButton = createButton("Logout", e -> dispose());
        buttonsPanel.add(logoutButton);

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private JButton createButton(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
    }

    private void openBrowseFlights() {
        BrowseFlights browseFlights = new BrowseFlights(); // Assuming BrowseFlights can handle user sessions
        browseFlights.setVisible(true);
    }

    private void cancelFlight() throws SQLException {
        // Cancel flight by booking ID
        String input = JOptionPane.showInputDialog(this, "Enter Booking ID to cancel:");
        if (input != null && !input.isEmpty()) {
            try {
                int bookingId = Integer.parseInt(input);
                // FlightInfo temp = FlightInfo.getFlightInfoByFlightId(bookingId); // Error here

                // Attempt to cancel the booking in the database
                if (Database.cancelBooking(bookingId)) {
                    // temp.setAvailability(bookingId);                             // Error here
                    JOptionPane.showMessageDialog(this, "Booking canceled successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Booking ID not found or could not be canceled.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid Booking ID.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace(); // Print or log the exception
                JOptionPane.showMessageDialog(this, "A database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void applyForCreditCard() {
        boolean success = currentUser.applyForCreditCard();
        if (success) {
            JOptionPane.showMessageDialog(this, "Credit card application successful!");
        } else {
            JOptionPane.showMessageDialog(this, "You already have a credit card.");
        }
    }
}
