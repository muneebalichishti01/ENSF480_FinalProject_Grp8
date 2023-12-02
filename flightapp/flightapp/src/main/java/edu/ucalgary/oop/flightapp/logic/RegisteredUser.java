package edu.ucalgary.oop.flightapp.logic;

import java.sql.*;
import java.time.LocalDate;

public class RegisteredUser extends User {
    private String address;
    private String creditCardNumber;
    private CreditCard creditCard;
    // New attributes
    private int loungeAccessId;     // ID for lounge access
    private int promotionId;        // ID for promotion
    private boolean companionTicket;  // ID for companion ticket
    private LocalDate lastCompanionTicketSetDate;

    // Constructor
    public RegisteredUser(int userId, String username, String email, String phoneNumber, boolean hasCancellationInsurance, 
                          String address, String creditCardNumber, int loungeAccessId, int promotionId) {
        super(userId, username, email, phoneNumber, hasCancellationInsurance);
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        // Initialize new variables
        this.loungeAccessId = loungeAccessId;
        this.promotionId = promotionId;
        this.companionTicket = true;
        this.lastCompanionTicketSetDate = LocalDate.now();
        Database.updateCompanionTicketDatabase(lastCompanionTicketSetDate, userId);
    }


    // Getters and setters
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    // Getters and setters for the new attributes
    public int getLoungeAccessId() {
        return loungeAccessId;
    }
    public void setLoungeAccessId(int loungeAccessId) {
        this.loungeAccessId = loungeAccessId;
    }

    public int getPromotionId() {
        return promotionId;
    }
    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public boolean getCompanionTicket() {
        return companionTicket;
    }
    public void setCompanionTicket(boolean tf) {
        this.companionTicket = tf;
    }

    public void useCompanionTicket() {
        LocalDate currentDate = LocalDate.now();
        LocalDate lastDate = Database.getLastCompanionTicketDate(getUserId());
    
        // Check if a year has passed since the last companion ticket set
        if (currentDate.isAfter(lastDate.plusYears(1))) {
            companionTicket = false;
            Database.updateCompanionTicketDatabase(currentDate, getUserId());
        }
    }
    

    // Override toString method to display registered user information
    @Override
    public String toString() {
        return "RegisteredUser{" +
                "userId=" + getUserId() +
                ", username='" + getUsername() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", hasCancellationInsurance=" + hasCancellationInsurance() +
                ", address='" + address + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", loungeAccessId=" + loungeAccessId +
                ", promotionId=" + promotionId +
                ", companionTicketId=" + companionTicket +
                '}';
    }
}
