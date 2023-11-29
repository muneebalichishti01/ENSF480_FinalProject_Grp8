import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AppGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public AppGUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2)); //need to fix dimensions

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register New User?");
        JButton guestButton = new JButton("Continue as Guest");


        //add components to the login screen
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);
        add(guestButton);

        guestButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e){
            dispose();
            guestHubInterface();
          }
        });

        //action listener for login button
        loginButton.addActionListener(new ActionListener() { //would need to do some tweaking here to verify whether its a flight attendant or not (easiest way would just do a button to check for flight attendant ig)
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                boolean isAuthenticated = authenticateUser(username, password); //does authentication of input

                if (isAuthenticated) {
                    //if authenticated, navigate to hub screen
                    dispose(); //close login
                    openHubInterface();
                } else {
                    //could add a isAuthenticatedAttendant method too
                    JOptionPane.showMessageDialog(AppGUI.this, "Invalid username or password.");
                }
            }
        });

        //action listener for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //close login screen
                openRegistrationInterface();
            }
        });

        pack();
        setLocationRelativeTo(null); //center the window
        setVisible(true);
    }

    //method to authenticate user against the database
    private boolean authenticateUser(String username, String password) { //or maybe here to check for FlightAttendant table. and authentication
        //connect to MySQL database, query for the user, and check password
        //just threw some bs code here NEED CHANGE once we connect db
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?"); //need to change this here too with the specific table in DB we are holding allat
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); //if a row is returned, user is authenticated

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //method to open the registration interface (in a separate class)
    private void openRegistrationInterface() {
      RegistrationInterface registrationInterface = new RegistrationInterface(this);
      registrationInterface.setVisible(true);
    }
  
    //can do everything but what is exclusive to RegisteredUser
    private void guestHubInterface(){

    }

    //method to open the hub interface
    //this would be where you can Browse Flights, Cancel Flight, with Registered user features
    private void openHubInterface() {

    }

    
    //this is a main im just using for testing, but I'm guessing we'd start the program on this class anyway
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppGUI());
    }
}
