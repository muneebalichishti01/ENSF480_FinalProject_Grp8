import java.util.*;
import java.sql.*;

public class Database {
  private Connection dbConnect;
  private ResultSet results;

  // Selects
  private static final String queryRegisteredUser = "SELECT * FROM RegisteredUser";
  private static final String queryFlightInfo = "SELECT * FROM FlightInfo";
  private static final String querySeatPrice = "SELECT * FROM SeatPrice";
  private static final String queryFlightAttendants = "SELECT * FROM FlightAttendants";

  private HashMap<Integer, RegisteredUser> regUsers = new HashMap<Integer, RegisteredUser>();              //hashmap holding object of class RegisteredUser
  private HashMap<Integer, FlightInfo> flightInfo = new HashMap<Integer, FlightInfo>();                    //hashmap holding flight information, to gather data such as seat info, passanger list, etc.
  private HashMap<String, Integer> seatPrice = new HashMap<String, Integer>();                             //hashmap holding seat name and its corresponding price (ordinary, comfort, etc.)
  private ArrayList<String> flightAttendants = new ArrayList<String>();                                    //flight attendant name (for login)
    
  /* Create a connection to the database */
  public void createConnection() {
    try {
      // dbConnect = DriverManager.getConnection("", "oop", "password");                    //Need to add proper URL to connect
      dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/FlightAppData", "root", "root"); // pass: root for personal; 1234 for university

    } 
    catch (SQLException e) {
      System.err.println("SQL Exception (File Not Found): " + e.getMessage());
      e.printStackTrace();
    }
  }

  /* Close the connection to database */
  public void closeConnection() {
    try {
      results.close();
      dbConnect.close();
    } 
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /* Pull the tables from the database and create hashmaps with IDs as keys and table objects for values */
  public void createHashMaps() {
    try {
      Statement stmt = dbConnect.createStatement();
      // Add treatments to hashmap with TaskID(key) and 
      results = stmt.executeQuery(queryRegisteredUser);
      while (results.next()) {
        RegisteredUser regUser = new RegisteredUser();                                                   //Constructor for registered user to be filled in when making RegisteredUser class  
        regUsers.put(, regUser);                                                                         //To be filled after making database
      }

      ResultSet results = stmt.executeQuery(queryFlightInfo);
      while (results.next()) {
        FlightInfo flight = new FlightInfo();                                                            //Constructor for registered user to be filled in when making RegisteredUser class 
        flightInfo.put(, flight);                                                                        //To be filled after making database
      }

      results = stmt.executeQuery(querySeatPrice);
      while (results.next()) {
        seatPrice.put();                                                                                 //To be filled after making database
      }

      results = stmt.executeQuery(queryFlightAttendants);
      while (results.next()) {
        flightAttendants.add();                                                                          //To be filled after making database
      }

      stmt.close();

    } 
    catch (SQLException e) {
      e.printStackTrace();
    }
  }
}


//passenger list, login info, flight infos, seat infos, payment info