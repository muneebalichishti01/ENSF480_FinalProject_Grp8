import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegistrationInterface extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private AppGUI parent;

    public RegistrationInterface(AppGUI parent) { //same process as standard login, just now will store user input and add to db
        this.parent = parent;

        setTitle("Register");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("New Username:");
        JLabel passwordLabel = new JLabel("New Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");

        //add components to the registration screen
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(registerButton);

        //action listener for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUsername = usernameField.getText();
                String newPassword = new String(passwordField.getPassword());

                //perform registration
                boolean isRegistered = registerUser(newUsername, newPassword);

                if (isRegistered) {
                    JOptionPane.showMessageDialog(RegistrationInterface.this, "Registration successful.");
                    dispose(); //close registration screen
                    parent.setVisible(true); //show the login screen again so user can input new info and then go into hub
                } else {
                    JOptionPane.showMessageDialog(RegistrationInterface.this, "Registration failed."); //just error catching
                }
            }
        });

        pack();
        setLocationRelativeTo(parent); //center relative to the parent window
    }

    //method to insert new user into the database (registration)
    private boolean registerUser(String username, String password) {
        //perform database insertion using JDBC
        //connect to MySQL database, insert new user (idk if we need to do a connection again, not sure the specifications of it tbh)
        //bs code i did to just use as example
        try {
            Connection connection = DriverManager.getConnection("", "username", "password");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            statement.setString(1, username);
            statement.setString(2, password);

            int rowsInserted = statement.executeUpdate(); //will just run the INSERT INTO MySQL command
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}