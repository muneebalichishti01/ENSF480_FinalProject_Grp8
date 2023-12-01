package edu.ucalgary.oop.flightapp.logic.GUI.navigation;

import edu.ucalgary.oop.flightapp.logic.GUI.panels.AdminDashboard;

public class NavigationController {
    private static final String USER_TYPE_ADMIN = "admin";
    private static final String USER_TYPE_GUEST = "guest";

    public void navigateToDashboard(String userType) {
        switch (userType) {
            case USER_TYPE_ADMIN:
                openAdminDashboard();
                break;
            case USER_TYPE_GUEST:
                //openGuestDashboard();
                break;
            // Add cases for other user types as needed
            default:
                // Handle cases for other user types or invalid input
                break;
        }
    }

    private void openAdminDashboard() {
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true);
    }

    // private void openGuestDashboard() {
    //     GuestDashboard guestDashboard = new GuestDashboard();
    //     guestDashboard.setVisible(true);
    // }

}