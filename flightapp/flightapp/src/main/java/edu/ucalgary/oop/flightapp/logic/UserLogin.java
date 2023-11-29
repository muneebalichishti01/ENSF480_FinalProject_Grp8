package edu.ucalgary.oop.flightapp.logic;
public class UserLogin {
    private static UserLogin instance = new UserLogin();

    private Database database;

    private UserLogin() {
        this.database = Database.getInstance();
    }

    public static UserLogin getInstance() {
        return instance;
    }

    // Method for user registration
    public boolean register(String username, String email, String phoneNumber, String password, boolean hasCancellationInsurance) {
        if (database.getUserByUsername(username) == null) {
            int userId = Database.getNextUserId();  // Generate a new user ID
            User newUser = new User(userId, username, email, phoneNumber, hasCancellationInsurance);
            Database.addUser(newUser);
            Database.storeUserPassword(userId, password);  // Store password in the database
            return true;
        }
        return false;
    }

    // Method for user login
    public boolean login(String username, String password) {
        // Logic to verify username and password against the database
        User user = database.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Successful login
            return true;
        }
        return false;
    }

    // Method for user logout - might not need database interaction
    public void logout(User user) {
        // Logic for user logout, if needed to interact with the database
    }
}
