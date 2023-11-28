import java.sql.Connection;
import java.util.HashMap;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static Connection connection;
    // Define HashMaps to simulate database tables
    private static HashMap<Integer, User> usersTable = new HashMap<>();
    private static HashMap<Integer, RegisteredUser> registeredUserTable = new HashMap<>();
    private static HashMap<Integer, FlightInfo> flightsTable = new HashMap<>();
    private static HashMap<Integer, Crew> crewTable = new HashMap<>();
    private static HashMap<Integer, Aircraft> aircraftTable = new HashMap<>();
    private static HashMap<Integer, BookingInfo> bookingInfoTable = new HashMap<>();
    private static HashMap<Integer, Promotions> promotionsTable = new HashMap<>();
    private static HashMap<Integer, LoungeAccess> loungeAccessTable = new HashMap<>();
    private static HashMap<Integer, CompanionTicket> companionTicketTable = new HashMap<>();

    public static void main(String[] args) {
        // Initialize the database connection
        initializeDatabase();

        // Now you can perform database operations
        // For example, you can query or update data using the 'connection' object
        // Make sure to handle exceptions and close the connection when done

        // Close the database connection when you're finished
        closeDatabase();
    }

    // Initialize the database connection
    public static void initializeDatabase() {
        // Database connection properties
        String url = "jdbc:mysql://localhost:3306/ewr";       // Change to your database URL
        Properties properties = new Properties();
        properties.setProperty("user", "root");     // Change to your database username
        properties.setProperty("password", "root"); // Change to your database password

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(url, properties);
            System.out.println("Database connection successful!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("SQL Exception (File Not Found): " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Close the database connection
    public static void closeDatabase() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Initialize the database tables
    public static void initializeData() {
        // Initialize User data
        User user1 = new User(1, "username1", "email1@example.com", "123-456-7890", false);
        User user2 = new User(2, "username2", "email2@example.com", "987-654-3210", true);
        usersTable.put(1, user1);
        usersTable.put(2, user2);

        // Initialize RegisteredUser data
        RegisteredUser registeredUser1 = new RegisteredUser(1, "Registered User 1", "email1@example.com", "123-456-7890", false, "Address 1", "1234-5678-9012-3456");
        RegisteredUser registeredUser2 = new RegisteredUser(2, "Registered User 2", "email2@example.com", "987-654-3210", true, "Address 2", "5678-9012-3456-7890");
        registeredUserTable.put(1, registeredUser1);
        registeredUserTable.put(2, registeredUser2);

        // Initialize Flight data
        FlightInfo flight1 = new FlightInfo(1, "Flight 1", "Destination 1", "Origin 1", "2023-12-01");
        FlightInfo flight2 = new FlightInfo(2, "Flight 2", "Destination 2", "Origin 2", "2023-12-02");
        flightsTable.put(1, flight1);
        flightsTable.put(2, flight2);

        // Initialize Crew data
        Crew crew1 = new Crew(1, "Crew Member 1", "Pilot");
        Crew crew2 = new Crew(2, "Crew Member 2", "Flight Attendant");
        crewTable.put(1, crew1);
        crewTable.put(2, crew2);

        // Initialize Aircraft data
        Aircraft aircraft1 = new Aircraft(1, "Aircraft 1", "Type 1");
        Aircraft aircraft2 = new Aircraft(2, "Aircraft 2", "Type 2");
        aircraftTable.put(1, aircraft1);
        aircraftTable.put(2, aircraft2);

        // Initialize BookingInfo data
        BookingInfo bookingInfo1 = new BookingInfo(1, user1, flight1, 100.0);
        BookingInfo bookingInfo2 = new BookingInfo(2, user2, flight2, 150.0);
        bookingInfoTable.put(1, bookingInfo1);
        bookingInfoTable.put(2, bookingInfo2);

        // Initialize Promotions data
        Promotions promotions1 = new Promotions(1, "Promo 1");
        Promotions promotions2 = new Promotions(2, "Promo 2");
        promotionsTable.put(1, promotions1);
        promotionsTable.put(2, promotions2);

        // Initialize LoungeAccess data
        LoungeAccess loungeAccess1 = new LoungeAccess(1, 1, 50.0);
        LoungeAccess loungeAccess2 = new LoungeAccess(2, 2, 60.0);
        loungeAccessTable.put(1, loungeAccess1);
        loungeAccessTable.put(2, loungeAccess2);

        // Initialize CompanionTicket data
        CompanionTicket companionTicket1 = new CompanionTicket(1, user1, user2);
        CompanionTicket companionTicket2 = new CompanionTicket(2, user2, user1);
        companionTicketTable.put(1, companionTicket1);
        companionTicketTable.put(2, companionTicket2);
    }
}
