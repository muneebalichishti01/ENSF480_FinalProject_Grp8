import java.util.HashMap;

public class LoungeAccess {
    private int userId;
    private int flightId;
    private double cost;

    // Constructor
    public LoungeAccess(int userId, int flightId, double cost) {
        this.userId = userId;
        this.flightId = flightId;
        this.cost = cost;
    }

    // Getters and setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // toString method

    @Override
    public String toString() {
        return "LoungeAccess{" +
                "userId=" + userId +
                ", flightId=" + flightId +
                ", cost=" + cost +
                '}';
    }

    // HashMap to store lounge accesses
    private static HashMap<Integer, LoungeAccess> loungeAccessTable = new HashMap<>();

    // Add lounge access to the HashMap
    public static void addLoungeAccess(LoungeAccess loungeAccess) {
        loungeAccessTable.put(loungeAccess.getUserId(), loungeAccess);
    }

    // Get lounge access from the HashMap by userId
    public static LoungeAccess getLoungeAccess(int userId) {
        return loungeAccessTable.get(userId);
    }

    // Get all lounge accesses from the HashMap
    public static HashMap<Integer, LoungeAccess> getAllLoungeAccesses() {
        return loungeAccessTable;
    }
}
