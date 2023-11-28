import java.util.HashMap;

public class Crew {
    private int crewId;
    private String name;
    private String role;

    // Constructor
    public Crew(int crewId, String name, String role) {
        this.crewId = crewId;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters
    public int getCrewId() {
        return crewId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Override toString method to display crew information
    @Override
    public String toString() {
        return "Crew{" +
                "crewId=" + crewId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    // Hash Map for Crew
    private static HashMap<Integer, Crew> crewMap = new HashMap<>();

    // Add crew member to the HashMap
    public static void addCrewMember(Crew crew) {
        crewMap.put(crew.getCrewId(), crew);
    }

    // Get crew member by crew ID from the HashMap
    public static Crew getCrewMemberByCrewId(int crewId) {
        return crewMap.get(crewId);
    }

    // Get all crew members from the HashMap
    public static HashMap<Integer, Crew> getAllCrewMembers() {
        return crewMap;
    }
}
