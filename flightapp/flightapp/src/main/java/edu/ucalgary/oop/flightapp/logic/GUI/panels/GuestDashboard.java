package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GuestDashboard extends JFrame {
  public GuestDashboard(){
    //initialize components and layout for admin dashboard
    setTitle("Guest Dashboard");
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
    panel.setBorder(BorderFactory.createEmptyBorder(20,20,20, 20));

    JLabel welcomeLabel = new JLabel("Welcome to your dashboard! Currently Logged in as Guest", SwingConstants.CENTER);
    panel.add(welcomeLabel);


    //browsing flights button
    JButton browseFlightsButton = new JButton("Browse Flghts");
    browseFlightsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        //here would go implementation to browse flights
        JOptionPane.showMessageDialog(GuestDashboard.this, "Browsing Flights...");
      }
    });
    panel.add(browseFlightsButton);

    
    //cancel existing flight button
    JButton cancelFlightButton = new JButton("Cancel Flight");
    cancelFlightButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        //implementation to cancel flight would go here
        JOptionPane.showMessageDialog(GuestDashboard.this, "Cancelling Flight...");
      }
    });
    panel.add(cancelFlightButton);

    //logout button
    JButton logoutButton = new JButton("Logout");
    logoutButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        //just closes the guest dashboard frame
        dispose();
      }
    });
    panel.add(logoutButton);
    
    add(panel);
  }
}
