package edu.ucalgary.oop.flightapp.logic.GUI.main;

import edu.ucalgary.oop.flightapp.logic.FlightInfo;
import edu.ucalgary.oop.flightapp.logic.GUI.panels.LoginPortal;

import javax.swing.*;

public class MainView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FlightInfo.initializeData(); // Error here
                LoginPortal loginPortal = new LoginPortal();
                loginPortal.setVisible(true);
            }
        });
    }
}
