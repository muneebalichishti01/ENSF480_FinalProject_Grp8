import java.util.HashMap;

public class FlightInfo {
    private int flightId;
    private String flightName;
    private String destination;
    private String origin;
    private String departureDate;

    // Constructor
    public FlightInfo(int flightId, String flightName, String destination, String origin, String departureDate) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.destination = destination;
        this.origin = origin;
        this.departureDate = departureDate;
    }

    // Getters and Setters
    public int getFlightId() {
        return flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    // Override toString method to display flight information
    @Override
    public String toString() {
        return "FlightInfo{" +
                "flightId=" + flightId +
                ", flightName='" + flightName + '\'' +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }

    // Hash Map for FlightInfo
    private static HashMap<Integer, FlightInfo> flightInfoMap = new HashMap<>();

    // Add flight info to the HashMap
    public static void addFlightInfo(FlightInfo flightInfo) {
        flightInfoMap.put(flightInfo.getFlightId(), flightInfo);
    }

    // Get flight info by flight ID from the HashMap
    public static FlightInfo getFlightInfoByFlightId(int flightId) {
        return flightInfoMap.get(flightId);
    }

    // Get all flight info entries from the HashMap
    public static HashMap<Integer, FlightInfo> getAllFlightInfo() {
        return flightInfoMap;
    }
}
