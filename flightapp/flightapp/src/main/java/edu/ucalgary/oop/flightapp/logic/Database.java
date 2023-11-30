package edu.ucalgary.oop.flightapp.logic;

import java.sql.*;
import java.util.*;

// public class Database extends PopulatingDatabase {
public class Database {
    private static Database instance;
    private static Connection connection;

    // Private constructor to prevent direct instantiation
    private Database() {
        initializeDatabase();  // Initialize database connection
    }

    // Static method to get the single instance of the class
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public static void main(String[] args) {
        Database dbInstance = Database.getInstance();
        try {
            User newUser1 = new User("ali", "ali@bigman.com", "888-654-321", true);
            boolean userAdded1 = dbInstance.addUserWithValidation(newUser1);
            
            if (userAdded1) {
                Database.storeUserPassword(newUser1.getUserId(), "password888");
                System.out.println("New user added: " + newUser1);
    
                // Rest of your testing code...
            } else {
                System.out.println("User already exists and was not added: " + newUser1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Database.closeDatabase();
        }
    }
    
    

    // Initialize database connection
    public static void initializeDatabase() {
        String url = "jdbc:mysql://localhost:3306/flightappdatabase";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, properties);
            System.out.println("-----------------------------------");
            System.out.println("Database connection successful!");
            System.out.println("-----------------------------------");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Close database connection
    public static void closeDatabase() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("-----------------------------------");
                System.out.println("Database connection closed.");
                System.out.println("-----------------------------------");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//-----------------------------------------User----------------------------------------------//
    // Method to get User by username
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phoneNumber");
                boolean hasCancellationInsurance = resultSet.getBoolean("hasCancellationInsurance");
                // Assuming these are the columns in your users table
                return new User(userId, username, email, phoneNumber, hasCancellationInsurance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to get the next User ID
    // public static int getNextUserId() {
    //     String sql = "SELECT MAX(userId) AS maxId FROM users";
    //     try (Statement statement = connection.createStatement();
    //          ResultSet resultSet = statement.executeQuery(sql)) {
    //         if (resultSet.next()) {
    //             return resultSet.getInt("maxId") + 1;
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return 1; // Start from 1 if table is empty
    // }

    // Method to add a new User
    public static void addUser(User newUser) {
    String sql = "INSERT INTO users (username, email, phoneNumber, hasCancellationInsurance) VALUES (?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        statement.setString(1, newUser.getUsername());
        statement.setString(2, newUser.getEmail());
        statement.setString(3, newUser.getPhoneNumber());
        statement.setBoolean(4, newUser.hasCancellationInsurance());
        statement.executeUpdate();

        // Retrieve the generated userId and set it to newUser
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                newUser.setUserId(generatedKeys.getInt(1));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // Method to store User's password
    public static void storeUserPassword(int userId, String password) {
        String sql = "INSERT INTO userPasswords (userId, passwordHash) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setString(2, password); // Hash the password in production
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    

    // Method to get User's password hash
    public String getUserPasswordHash(int userId) {
        String sql = "SELECT passwordHash FROM userPasswords WHERE userId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("passwordHash");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if password hash not found or error occurred
    }

    // Method to add a new User with validation
    public boolean addUserWithValidation(User newUser) {
        if (userExists(newUser.getUsername(), newUser.getEmail())) {
            return false; // User already exists, do not add
        }
    
        String sql = "INSERT INTO users (username, email, phoneNumber, hasCancellationInsurance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, newUser.getUsername());
            statement.setString(2, newUser.getEmail());
            statement.setString(3, newUser.getPhoneNumber());
            statement.setBoolean(4, newUser.hasCancellationInsurance());
            statement.executeUpdate();
    
            // Retrieve the generated userId and set it to newUser
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newUser.setUserId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    // Method to check if a user already exists
    private boolean userExists(String username, String email) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?")) {
            statement.setString(1, username);
            statement.setString(2, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0; // Return true if count is greater than 0
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to update a User
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET email = ?, phoneNumber = ?, hasCancellationInsurance = ? WHERE userId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPhoneNumber());
            statement.setBoolean(3, user.hasCancellationInsurance());
            statement.setInt(4, user.getUserId());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
//-----------------------------------------User----------------------------------------------//
//--------------------------------------Credit Card------------------------------------------//
    // Method to add a new CreditCard
    public static void addCreditCard(CreditCard creditCard) {
        String sql = "INSERT INTO creditCards (userId, cardNumber, expiryDate, cvv) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, creditCard.getUserId());
            statement.setString(2, creditCard.getCardNumber());
            statement.setString(3, creditCard.getExpiryDate());
            statement.setString(4, creditCard.getCvv());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//--------------------------------------Credit Card------------------------------------------//

    // Other methods ...
}

   

   