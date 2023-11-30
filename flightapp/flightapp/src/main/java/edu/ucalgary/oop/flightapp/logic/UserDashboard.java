package edu.ucalgary.oop.flightapp.logic;

import java.util.HashMap;

public class UserDashboard {
    // HashMap to store users
    private static HashMap<Integer, User> usersTable = new HashMap<>();
    // HashMap to store registered users
    // private static HashMap<Integer, RegisteredUser> registeredUserTable = new HashMap<>();
    // // HashMap to store flight information
    // private static HashMap<Integer, FlightInfo> flightsTable = new HashMap<>();
    // // HashMap to store flight attendants
    // private static HashMap<Integer, FlightAttendant> FlightAttendantTable = new HashMap<>();
    // // HashMap to store aircraft
    // private static HashMap<Integer, Aircraft> aircraftTable = new HashMap<>();
    // // HashMap to store booking information
    // private static HashMap<Integer, BookingInfo> bookingInfoTable = new HashMap<>();
    // // HashMap to store promotions
    // private static HashMap<Integer, Promotions> promotionsTable = new HashMap<>();
    // // HashMap to store lounge access
    // private static HashMap<Integer, LoungeAccess> loungeAccessTable = new HashMap<>();
    // // HashMap to store companion tickets
    // private static HashMap<Integer, CompanionTicket> companionTicketTable = new HashMap<>();

    // Add users to the HashMap
    public static void addUser(User user) {
        usersTable.put(user.getUserId(), user);
    }
    // Get a user from the HashMap by userId
    public static User getUser(int userId) {
        return usersTable.get(userId);
    }

    // Main method to test the code
    public static void main(String[] args) { 
        
        User user = new User(1, "ali02",               // Create a user
        "ali@ali.com", "12345",
        true);
        addUser(user);                                                 // Add the user to the HashMap
        User user1 = getUser(1);                                // Get the user from the HashMap by userId
        System.out.println(user1.toString());                          // Print the user information

        RegisteredUser regUser = new RegisteredUser(1,          // Create a registered user
        "ali02", "ali@ali.com",
        "12345",
        true,
        "12 3 avenue NW",
        "222-222-2222",
        0, 0, 0);
        
        addUser(regUser);                                              // Add the registered user to the HashMap                
        RegisteredUser regUser1 = (RegisteredUser) getUser(1);  // Get the registered user from the HashMap by userId
        System.out.println(regUser1.toString());                       // Print the registered user information
        
        // Decorator Pattern
        Seat ordinarySeat = new OrdinarySeat();                        // Create a seat
        Seat comfortSeat = new ComfortSeat(new OrdinarySeat());        // Create a comfort seat
        Seat businessSeat = new BusinessSeat(new OrdinarySeat());      // Create a business seat
        System.out.println(ordinarySeat.getDescription() +             // Print the ordinary seat description and cost
        ": $" + ordinarySeat.getCost());
        System.out.println(comfortSeat.getDescription() +              // Print the comfort seat description and cost
        ": $" + comfortSeat.getCost());
        System.out.println(businessSeat.getDescription() +             // Print the business seat description and cost
        ": $" + businessSeat.getCost());
    }
}
