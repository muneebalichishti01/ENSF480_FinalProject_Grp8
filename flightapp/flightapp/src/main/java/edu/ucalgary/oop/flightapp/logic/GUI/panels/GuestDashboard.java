package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import edu.ucalgary.oop.flightapp.logic.BookingInfo;
import edu.ucalgary.oop.flightapp.logic.FlightInfo;

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
        String input = JOptionPane.showInputDialog(GuestDashboard.this, "Enter Booking ID to cancel:");
        try {
            int bookingId = Integer.parseInt(input);

            boolean found = false;
            for (FlightInfo flight : FlightInfo.getAllFlightInfo()) {
                for (BookingInfo booking : flight.getPassengerBookings()) {
                    if (booking.getBookingId() == bookingId) {
                        flight.removeBooking(booking); // Remove the booking
                        flight.setBooking(booking.getSeat().getSeatID()); // Set the seat as available
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }

            if (found) {
                JOptionPane.showMessageDialog(GuestDashboard.this, "Booking canceled successfully.");
            } else {
                JOptionPane.showMessageDialog(GuestDashboard.this, "Booking ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(GuestDashboard.this, "Please enter a valid Booking ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            // Handle the SQLException here
            ex.printStackTrace(); // Print or log the exception
            JOptionPane.showMessageDialog(GuestDashboard.this, "A database error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
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
