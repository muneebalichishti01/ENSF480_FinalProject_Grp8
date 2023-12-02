package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import java.awt.GridLayout;
import java.awt.event.ActionListener;


import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;

public class UserDashboard extends JFrame {
  public UserDashboard() {
    // Initialize components and layout for the user dashboard
    setTitle("User Dashboard");
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel(new GridLayout(4,1,10,10));
    panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

    JLabel welcomeLabel = new JLabel("Welcome to your dashboard! Currently logged in as user");
    panel.add(welcomeLabel);

    JButton browseFlightsButton = new JButton("Browse Flights");
    browseFlightsButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(UserDashboard.this, "Browsing Flights");
      }
    });
    panel.add(browseFlightsButton);

    JButton cancelFlightButton = new JButton("Cancel Flight");
    cancelFlightButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(UserDashboard.this, "Cancel Flights");
      }
    });
    panel.add(cancelFlightButton);

    JButton logoutButton = new JButton("Logout");
    logoutButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        dispose();
      }
    });
    panel.add(logoutButton);

    add(panel);
  }
}
