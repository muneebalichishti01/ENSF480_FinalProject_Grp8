import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegisteredUser extends User {
    private String address;
    private String creditCardNumber;
    private boolean hasCompanionTicket;
    private HashMap<Integer, String> monthlyPromotions = new HashMap<>();
    private double loungeDiscount;

    // Constructors
    public RegisteredUser(int userId, String username, String email, String phoneNumber, boolean hasCancellationInsurance,
                          String address, String creditCardNumber) {
        super(userId, username, email, phoneNumber, hasCancellationInsurance);
        this.address = address;
        this.creditCardNumber = creditCardNumber;
    }

    // Getters and setters

    public int getUserId() {
        return userId;
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

    public boolean hasCompanionTicket() {
        return hasCompanionTicket;
    }

    public void setHasCompanionTicket(boolean hasCompanionTicket) {
        this.hasCompanionTicket = hasCompanionTicket;
    }

    public double getLoungeDiscount() {
        return loungeDiscount;
    }

    public void setLoungeDiscount(double loungeDiscount) {
        this.loungeDiscount = loungeDiscount;
    }

    // Methods to manage monthly promotions

    public void addMonthlyPromotion(int promotionId, String promotionName) {
        monthlyPromotions.put(promotionId, promotionName);
    }

    public String getMonthlyPromotion(int promotionId) {
        return monthlyPromotions.get(promotionId);
    }

    public List<String> getAllMonthlyPromotions() {
        return new ArrayList<>(monthlyPromotions.values());
    }

    // toString method to display registered user information
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
                ", hasCompanionTicket=" + hasCompanionTicket +
                ", monthlyPromotions=" + monthlyPromotions +
                ", loungeDiscount=" + loungeDiscount +
                '}';
    }
}
