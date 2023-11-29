package edu.ucalgary.oop.flightapp.logic;

import java.util.HashMap;

// public class User extends UserDashboard{
public class User {
    protected int userId;
    private String username;
    private String email;
    private String phoneNumber;
    private boolean hasCancellationInsurance;

    // Constructor
    public User(int userId, String username, String email, String phoneNumber, boolean hasCancellationInsurance) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasCancellationInsurance = hasCancellationInsurance;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean hasCancellationInsurance() {
        return hasCancellationInsurance;
    }
    public void setHasCancellationInsurance(boolean hasCancellationInsurance) {
        this.hasCancellationInsurance = hasCancellationInsurance;
    }

    // Override toString method to display user information
    @Override
    public String toString() {
        return "User Details:\n" +
            "User ID: " + userId + "\n" +
            "Username: " + username + "\n" +
            "Email: " + email + "\n" +
            "Phone Number: " + phoneNumber + "\n" +
            "Cancellation Insurance: " + (hasCancellationInsurance ? "Yes" : "No");
    }

    // @Override
    // public String toString() {
    //     return "User{" +
    //             "userId=" + userId +
    //             ", username='" + username + '\'' +
    //             ", email='" + email + '\'' +
    //             ", phoneNumber='" + phoneNumber + '\'' +
    //             ", hasCancellationInsurance=" + hasCancellationInsurance +
    //             '}';
    // }

    // Hash Map for Users
    private static HashMap<Integer, User> usersMap = new HashMap<>();

    // Add user to the HashMap
    public static void addUser(User user) {
        usersMap.put(user.getUserId(), user);
    }

    // Get user by ID from the HashMap
    public static User getUserById(int userId) {
        return usersMap.get(userId);
    }

    // Get all users from the HashMap
    public static HashMap<Integer, User> getAllUsers() {
        return usersMap;
    }

    public Object getPassword() {
        return null;
    }
}
