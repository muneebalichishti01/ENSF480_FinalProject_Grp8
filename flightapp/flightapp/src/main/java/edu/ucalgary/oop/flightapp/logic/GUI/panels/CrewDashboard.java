package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CrewDashboard extends JFrame {
  public CrewDashboard(){
    //initialize components and layout for admin dashboard
    setTitle("Crew Dashboard");
    setSize(400, 300);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridLayout(5,1,10,10));
    panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

    JLabel welcomeLabel = new JLabel("Welcome to the crew dashboard", SwingConstants.CENTER);
    panel.add(welcomeLabel);

    //button for browsing flights
    JButton browseFlightsButton = new JButton("Browse Flights");
    browseFlightsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e){
        //here we would implement the logic to browse flights
        ArrayList<String> availableFlights = new ArrayList<>();
        // availableFlights.add("Flight 1");
        // availableFlights.add("Flight 2");
        // availableFlights.add("Flight 3");

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
          // Retrieve passenger list for the selected flight (replace this with your logic)
          ArrayList<String> passengerList = retrievePassengerList(selectedFlight);

          // Display the passenger list in a dialog
          StringBuilder passengerInfo = new StringBuilder("Passenger List for " + selectedFlight + ":\n");
          for (String passenger : passengerList) {
              passengerInfo.append(passenger).append("\n");
          }
          JOptionPane.showMessageDialog(CrewDashboard.this, passengerInfo.toString());
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

// Method to simulate retrieving the passenger list for a selected flight
private ArrayList<String> retrievePassengerList(String selectedFlight) {
  // Implement logic to retrieve passenger list based on the selected flight
  // This could involve querying a database or accessing stored data
  // For demo purposes, let's simulate a passenger list for the selected flight
  ArrayList<String> passengerList = new ArrayList<>();
  passengerList.add("Passenger 1");
  passengerList.add("Passenger 2");
  passengerList.add("Passenger 3");
  // ... add more passengers

  return passengerList;
  } 
}
