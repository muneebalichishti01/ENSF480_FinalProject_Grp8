package edu.ucalgary.oop.flightapp.logic;

public class Payment {
    // Instance variables
    private int paymentId;
    private User user;
    private double amount;
    private String paymentStatus;

    // Attributes from CompanionTicket
    private int companionTicketId;      // The companion ticket ID
    private User primaryUser;           // The primary user for the companion ticket
    private User companionUser;         // The companion user for the companion ticket

    // Constructor
    public Payment(int paymentId, User user, double amount, int companionTicketId, User primaryUser, User companionUser) {
        this.paymentId = paymentId;
        this.user = user;
        this.amount = amount;
        this.paymentStatus = "Pending";

        // Initializing the new attributes
        this.companionTicketId = companionTicketId;
        this.primaryUser = primaryUser;
        this.companionUser = companionUser;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Getters and setters for the new attributes
    public int getCompanionTicketId() {
        return companionTicketId;
    }
    public void setCompanionTicketId(int companionTicketId) {
        this.companionTicketId = companionTicketId;
    }

    public User getPrimaryUser() {
        return primaryUser;
    }
    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
    }

    public User getCompanionUser() {
        return companionUser;
    }
    public void setCompanionUser(User companionUser) {
        this.companionUser = companionUser;
    }

    // Process payment method
    public void processPayment() {
        // Logic to process the payment
        // For now, let's assume all payments are successful
        this.paymentStatus = "Successful";
        // Integrate with a payment gateway
    }

    // Update payment details
    public void updatePaymentDetails(double newAmount) {
        this.amount = newAmount;
    }

    // Additional methods...
}
