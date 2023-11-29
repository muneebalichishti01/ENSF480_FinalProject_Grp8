package edu.ucalgary.oop.flightapp.logic;

import java.util.HashMap;
import java.util.Map;

public class RegisteredUser extends User {
    private String address;
    private String creditCardNumber;
    private Map<Integer, LoungeAccess> loungeAccesses;
    private Map<Integer, Promotions> promotions;
    private Map<Integer, CompanionTicket> companionTickets;

    // Constructor
    public RegisteredUser(int userId, String username, String email, String phoneNumber, boolean hasCancellationInsurance, 
                          String address, String creditCardNumber) {
        super(userId, username, email, phoneNumber, hasCancellationInsurance);
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.loungeAccesses = new HashMap<>();
        this.promotions = new HashMap<>();
        this.companionTickets = new HashMap<>();
    }
    
    // Getters and setters
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public Map<Integer, LoungeAccess> getLoungeAccesses() {
        return loungeAccesses;
    }
    public void setLoungeAccesses(Map<Integer, LoungeAccess> loungeAccesses) {
        this.loungeAccesses = loungeAccesses;
    }

    public Map<Integer, Promotions> getPromotions() {
        return promotions;
    }
    public void setPromotions(Map<Integer, Promotions> promotions) {
        this.promotions = promotions;
    }

    public Map<Integer, CompanionTicket> getCompanionTickets() {
        return companionTickets;
    }
    public void setCompanionTickets(Map<Integer, CompanionTicket> companionTickets) {
        this.companionTickets = companionTickets;
    }

    // Methods to manage lounge access, promotions, and companion tickets
    public void addLoungeAccess(LoungeAccess access) {
        loungeAccesses.put(access.getUserId(), access);
    }

    public void addPromotion(Promotions promotion) {
        promotions.put(promotion.getPromotionId(), promotion);
    }

    public void addCompanionTicket(CompanionTicket ticket) {
        companionTickets.put(ticket.getTicketId(), ticket);
    }

    public void removeLoungeAccess(int id) {
        loungeAccesses.remove(id);
    }
    public void removePromotion(int id) {
        promotions.remove(id);
    }
    public void removeCompanionTicket(int id) {
        companionTickets.remove(id);
    }
    public void removeAllLoungeAccesses() {
        loungeAccesses.clear();
    }
    public void removeAllPromotions() {
        promotions.clear();
    }
    public void removeAllCompanionTickets() {
        companionTickets.clear();
    }

    public void removeAll() {
        removeAllLoungeAccesses();
        removeAllPromotions();
        removeAllCompanionTickets();
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
                '}';
    }
}
