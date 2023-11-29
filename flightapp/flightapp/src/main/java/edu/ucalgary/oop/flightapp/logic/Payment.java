package edu.ucalgary.oop.flightapp.logic;

public class Payment {
    // Instance variables
    private int paymentId;
    private User user;
    private double amount;
    private String paymentStatus;

    // Constructor
    public Payment(int paymentId, User user, double amount) {
        this.paymentId = paymentId;
        this.user = user;
        this.amount = amount;
        this.paymentStatus = "Pending";
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }
    public User getUser() {
        return user;
    }
    public double getAmount() {
        return amount;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
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
}

