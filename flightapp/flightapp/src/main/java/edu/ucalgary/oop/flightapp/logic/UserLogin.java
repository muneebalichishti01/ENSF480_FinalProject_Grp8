package edu.ucalgary.oop.flightapp.logic;

public class UserLogin {
    // Instance variables
    private static UserLogin instance = new UserLogin();
    private Database database;

    // Constructor
    private UserLogin() {
        this.database = Database.getInstance();
    }

    // Singleton
    public static UserLogin getInstance() {
        return instance;
    }

    // Method for user registration
    public boolean register(String username, String email, String phoneNumber, String password, boolean hasCancellationInsurance) {
        if (database.getUserByUsername(username) == null) {
            // Create a new User with a temporary userId (e.g., 0)
            User newUser = new User(0, username, email, phoneNumber, hasCancellationInsurance);
            boolean userAdded = database.addUserWithValidation(newUser);
            if (userAdded) {
                // After adding, newUser's userId will be set by the database
                Database.storeUserPassword(newUser.getUserId(), password);
                return true;
            }
        }
        return false;
    }

    // Modified method for user login
    public User login(String username, String password) {
        User user = database.getUserByUsername(username);
        if (user != null) {
            String storedPassword = database.getUserPasswordHash(user.getUserId());
            if (storedPassword != null && storedPassword.equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Method for user logout - might not need database interaction
    public void logout(User user) {
        // Logic for user logout
    }
}
