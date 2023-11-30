package edu.ucalgary.oop.flightapp.logic.ARCHIVED;
//remove this file
import java.util.HashMap;

import edu.ucalgary.oop.flightapp.logic.User;

public class CompanionTicket {
    // Instance variables
    private int ticketId;
    private User primaryUser;
    private User companionUser;

    // Constructors
    public CompanionTicket(int ticketId, User primaryUser, User companionUser) {
        this.ticketId = ticketId;
        this.primaryUser = primaryUser;
        this.companionUser = companionUser;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public User getPrimaryUser() {
        return primaryUser;
    }
    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
    }

    public User getCompanionUser() {
        return companionUser;
    }
    public void setCompanionUser(User companionUser) {
        this.companionUser = companionUser;
    }

    // Override toString method to display companion ticket information
    @Override
    public String toString() {
        return "CompanionTicket{" +
                "ticketId=" + ticketId +
                ", primaryUser=" + primaryUser +
                ", companionUser=" + companionUser +
                '}';
    }

    // Hash Map for Companion Tickets
    private static HashMap<Integer, CompanionTicket> companionTicketMap = new HashMap<>();

    // Add a companion ticket to the HashMap
    public static void addCompanionTicket(CompanionTicket companionTicket) {
        companionTicketMap.put(companionTicket.getTicketId(), companionTicket);
    }

    // Get a companion ticket by ticket ID from the HashMap
    public static CompanionTicket getCompanionTicketByTicketId(int ticketId) {
        return companionTicketMap.get(ticketId);
    }

    // Get all companion tickets from the HashMap
    public static HashMap<Integer, CompanionTicket> getAllCompanionTickets() {
        return companionTicketMap;
    }
}

