import java.util.*;
import java.sql.*;

public class Database {
    private HashMap<Integer, RegisteredUser> regUsers; //hashmap holding object of class RegisteredUser
    private ArrayList<String> flightAttendant; //flight attendant name (for login)
    private HashMap<Integer, FlightInfo> flightInfo; //hashmap holding flight information, to gather data such as seat info, passanger list, etc.
    private HashMap<String, Integer> seatPrice; //hashmap holding seat name and its corresponding price (ordinary, comfort, etc.)
    final private Connection DB_CONNECT;

    public Database(String dbName, String user, String password, ) throws SQLException {
        
    }
    

    public void creatHashMaps(){
      try{

      }
    }
}


//passenger list, login info, flight infos, seat infos, payment info