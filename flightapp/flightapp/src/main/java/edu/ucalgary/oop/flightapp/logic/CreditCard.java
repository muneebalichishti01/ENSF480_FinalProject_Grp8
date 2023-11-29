package edu.ucalgary.oop.flightapp.logic;

public class CreditCard {
    private int userId;
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    // Constructor
    public CreditCard(int userId, String cardNumber, String expiryDate, String cvv) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    // Override toString method to display credit card information
    @Override
    public String toString() {
        return "CreditCard{" +
                "userId=" + userId +
                ", cardNumber='" + cardNumber + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}

