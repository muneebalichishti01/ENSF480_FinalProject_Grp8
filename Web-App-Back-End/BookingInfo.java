import java.util.HashMap;

public class BookingInfo {
    private int bookingId;
    private User user; // Change from int to User object
    private FlightInfo flightInfo; // Change from int to FlightInfo object
    private double ticketPrice;

    // Constructors
    public BookingInfo(int bookingId, User user, FlightInfo flightInfo, double ticketPrice) {
        this.bookingId = bookingId;
        this.user = user;
        this.flightInfo = flightInfo;
        this.ticketPrice = ticketPrice;
    }

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public void setFlightInfo(FlightInfo flightInfo) {
        this.flightInfo = flightInfo;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    // toString method to display booking information
    @Override
    public String toString() {
        return "BookingInfo{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", flightInfo=" + flightInfo +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    // Hash Map for Booking Information
    private static HashMap<Integer, BookingInfo> bookingInfoMap = new HashMap<>();

    // Add booking information to the HashMap
    public static void addBookingInfo(BookingInfo bookingInfo) {
        bookingInfoMap.put(bookingInfo.getBookingId(), bookingInfo);
    }

    // Get booking information by booking ID from the HashMap
    public static BookingInfo getBookingInfoByBookingId(int bookingId) {
        return bookingInfoMap.get(bookingId);
    }

    // Get all booking information from the HashMap
    public static HashMap<Integer, BookingInfo> getAllBookingInfo() {
        return bookingInfoMap;
    }
}
