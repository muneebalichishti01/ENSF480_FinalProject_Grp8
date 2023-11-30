package edu.ucalgary.oop.flightapp.logic;

public class RegisteredUser extends User {
    private String address;
    private String creditCardNumber;
    private CreditCard creditCard;

    // New attributes
    private int loungeAccessId;     // ID for lounge access
    private int promotionId;        // ID for promotion
    private int companionTicketId;  // ID for companion ticket

    // Constructor
    public RegisteredUser(int userId, String username, String email, String phoneNumber, boolean hasCancellationInsurance, 
                          String address, String creditCardNumber, int loungeAccessId, int promotionId, int companionTicketId) {
        super(userId, username, email, phoneNumber, hasCancellationInsurance);
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        
        // Initialize new variables
        this.loungeAccessId = loungeAccessId;
        this.promotionId = promotionId;
        this.companionTicketId = companionTicketId;
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

    public int getCompanionTicketId() {
        return companionTicketId;
    }
    public void setCompanionTicketId(int companionTicketId) {
        this.companionTicketId = companionTicketId;
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
                ", companionTicketId=" + companionTicketId +
                '}';
    }
}
