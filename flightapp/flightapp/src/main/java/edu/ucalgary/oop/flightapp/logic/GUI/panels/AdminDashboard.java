package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import javax.swing.*;

import edu.ucalgary.oop.flightapp.logic.Database;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {
    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton manageAircraftsButton = new JButton("Manage Aircrafts");
        manageAircraftsButton.addActionListener(e -> manageAircrafts());
        panel.add(manageAircraftsButton);

        JButton manageFlightsButton = new JButton("Manage Flights");
        manageFlightsButton.addActionListener(e -> manageFlights());
        panel.add(manageFlightsButton);

        JButton manageCrewsButton = new JButton("Manage Crews");
        manageCrewsButton.addActionListener(e -> manageCrews());
        panel.add(manageCrewsButton);

        add(panel);
    }

    private void manageAircrafts() {
        // Placeholder for managing aircrafts logic
        Database.getAllAircrafts();
        JOptionPane.showMessageDialog(this, "Manage Aircrafts functionality to be implemented.");
    }

    private void manageFlights() {
        Database.getAllFlights();
        // Placeholder for managing flights logic
        JOptionPane.showMessageDialog(this, "Manage Flights functionality to be implemented.");
    }

    private void manageCrews() {
        // Placeholder for managing crews logic
        JOptionPane.showMessageDialog(this, "Manage Crews functionality to be implemented.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AdminDashboard adminDashboard = new AdminDashboard();
            adminDashboard.setVisible(true);
        });
    }
}
