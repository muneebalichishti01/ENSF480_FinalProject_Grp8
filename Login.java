import java.util.ArrayList;

public class Login {
    private ArrayList<String> registeredUsers;
    private ArrayList<String> flightAttendants;
    public static Login onlyInstance; //Singleton for only instance of login

    private Login(){
        setRegisteredUser();
        setFlightAttendant();
    }

    public static Login getOnlyInstance() {
        if(onlyInstance == null){
            //if onlyInstance null create new Login instance
            onlyInstance = new Login();
        }
        return onlyInstance;
    }

    public void setRegisteredUser() {}
    public void setFlightAttendant() {}

    public Boolean checkRegisteredUser() {
        return true;
    }
    public Boolean checkFlightAttendant() {
        return true;
    }
}