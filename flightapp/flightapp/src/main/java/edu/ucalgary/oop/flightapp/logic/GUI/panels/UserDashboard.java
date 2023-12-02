package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import edu.ucalgary.oop.flightapp.logic.User; // Import the User class

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class UserDashboard extends JFrame {
    public UserDashboard(User currentUser) {
        // Initialize components and layout for the user dashboard
        setTitle("User Dashboard - " + currentUser.getUsername()); // Display username in title
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Main panel with BorderLayout to add buttons panel in the center
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Panel for buttons with GridLayout
        JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        // Welcome label with username
        JLabel welcomeLabel = new JLabel("Welcome to your dashboard, " + currentUser.getUsername() + "!");
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        // Browse flights button
        JButton browseFlightsButton = new JButton("Browse Flights");
        browseFlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(UserDashboard.this, "Browsing Flights");
            }
        });
        buttonsPanel.add(browseFlightsButton);

        // Cancel flight button
        JButton cancelFlightButton = new JButton("Cancel Flight");
        cancelFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(UserDashboard.this, "Cancel Flights");
            }
        });
        buttonsPanel.add(cancelFlightButton);

        // Apply for credit card button
        JButton applyCreditCardButton = new JButton("Apply for Credit Card");
        applyCreditCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean success = currentUser.applyForCreditCard();
                if (success) {
                    JOptionPane.showMessageDialog(UserDashboard.this, "Credit card application successful!");
                } else {
                    JOptionPane.showMessageDialog(UserDashboard.this, "You already have a credit card.");
                }
            }
        });
        buttonsPanel.add(applyCreditCardButton);

        // Logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonsPanel.add(logoutButton);

        // Add buttons panel to the center of the main panel
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        // Add main panel to the frame
        add(mainPanel);
    }
}
