package edu.ucalgary.oop.flightapp.logic;

import java.time.LocalDate;

// public class User extends UserDashboard{
public class User {
    protected int userId;
    private String username;
    private String email;
    private String phoneNumber;
    private boolean hasCreditCard;
    private LocalDate lastCompanionTicketSetDate;
    private boolean companionTicket;
    

    // Constructor
    public User(int userId, String username, String email, String phoneNumber, boolean hasCreditCard) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasCreditCard = hasCreditCard;
        companionTicket = true;

        this.lastCompanionTicketSetDate = LocalDate.now();
        Database.updateCompanionTicketDatabase(lastCompanionTicketSetDate, userId);
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getHasCreditCard() {
        return hasCreditCard;
    }

    public LocalDate getLastCompanionTicketSetDate() {
        return lastCompanionTicketSetDate;
    }

    public boolean getCompanionTicket() {
        return companionTicket;
    }
    
    public boolean applyForCreditCard() {
        if(hasCreditCard == true) {
            return false;                           // Return False if user already has credit card
        } else {
            hasCreditCard = true;                   // Return True if user gets a new card
            Database.updateUser(this);
            return true;
        }
    }

    public void useCompanionTicket() {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastDate = Database.getLastCompanionTicketDate(getUserId());
    
        // Check if a year has passed since the last companion ticket set
        if (currentDate.isAfter(lastDate.plusYears(1)) || companionTicket == true) {
            companionTicket = false;
            Database.updateCompanionTicketDatabase(currentDate, getUserId());
        }
    }

}
