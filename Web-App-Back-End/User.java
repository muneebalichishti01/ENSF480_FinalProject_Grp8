public class User {
    private int userId;
    private String username;
    private String email;
    private String phoneNumber;
    private boolean hasCancellationInsurance;

    // Constructors
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

    // toString method to display user information
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hasCancellationInsurance=" + hasCancellationInsurance +
                '}';
    }
}
