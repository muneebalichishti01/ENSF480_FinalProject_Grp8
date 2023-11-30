package edu.ucalgary.oop.flightapp.logic;

import javax.swing.*;

import jakarta.websocket.OnError;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPortal extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private JPanel loginPanel = new JPanel(new GridBagLayout());
    private JPanel signUpPanel = new JPanel(new GridBagLayout());
    private GridBagConstraints constraints = new GridBagConstraints();

    // private JPanel adminLoginPanel; // Add adminLoginPanel
    // private JPanel crewLoginPanel;

    public LoginPortal() {
        createLoginView();
        createSignUpView();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(signUpPanel, "SignUp");
        getContentPane().add(mainPanel);

        setTitle("Login/Sign Up Portal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // Adjusts the frame to preferred sizes
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void addToPanel(JPanel panel, Component component, int gridx, int gridy, int gridwidth, int anchor) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.anchor = anchor;
        constraints.insets = new Insets(4, 4, 4, 4); // Padding
        panel.add(component, constraints);
    }

    // private void initializeAdminLoginPanel(){
    //     adminLoginPanel = new JPanel(new GridBagLayout());
    // }

    // private void initializeCrewLoginPanel(){
    //     crewLoginPanel = new JPanel(new GridBagLayout());
    // }
    
    private void createLoginView() {
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton switchToSignUp = new JButton("Sign Up");
        JButton crewLogIn = new JButton("Crew Log In");
        JButton adminLogIn = new JButton("Admin Log In");
    
        // Adding components to the panel with grid (x, y) positions
        addToPanel(loginPanel, new JLabel("Username:"), 0, 0, 1, GridBagConstraints.WEST);
        addToPanel(loginPanel, usernameField, 1, 0, 2, GridBagConstraints.CENTER);
    
        addToPanel(loginPanel, new JLabel("Password:"), 0, 1, 1, GridBagConstraints.WEST);
        addToPanel(loginPanel, passwordField, 1, 1, 2, GridBagConstraints.CENTER);
    
        addToPanel(loginPanel, loginButton, 0, 2, 1, GridBagConstraints.CENTER);
        addToPanel(loginPanel, switchToSignUp, 1, 2, 1, GridBagConstraints.CENTER);
    
        addToPanel(loginPanel, adminLogIn, 0, 3, 1, GridBagConstraints.CENTER);
        addToPanel(loginPanel, crewLogIn, 1, 3, 1, GridBagConstraints.CENTER);
    
        // Action listeners for the buttons
        // Add appropriate action listeners for loginButton, switchToSignUp, crewLogIn, adminLogIn
        // ...
        switchToSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "SignUp");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
        
                // Hash the password before checking it against the database
                String hashedPassword = password;
        
                try {
                    Connection conn = Database.getInstance().getConnection();
                    // Adjusted SQL query to join the users and userPasswords tables
                    String sql = "SELECT up.* FROM users u JOIN userPasswords up ON u.userId = up.userId WHERE u.username = ? AND up.passwordHash = ?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, username);
                    statement.setString(2, hashedPassword);
                    
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        // User exists, login successful
                        JOptionPane.showMessageDialog(LoginPortal.this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        // Proceed to user dashboard or appropriate next step
                        UserDashboard userDashboard = new UserDashboard();
                        userDashboard.setVisible(true);
                        dispose();
                    } else {
                        // User does not exist, login failed
                        JOptionPane.showMessageDialog(LoginPortal.this, "Login failed!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(LoginPortal.this, "A database error occurred.", "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        adminLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(mainPanel, "AdminLogIn");
            }
        });

        crewLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout.show(mainPanel, "CrewLogIn");
            }
        });

        //initializeAdminLoginPanel();
        //initializeCrewLoginPanel();

        // mainPanel.add(adminLoginPanel, "AdminLogIn");
        // mainPanel.add(crewLoginPanel, "CrewLogIn");
               
    }   
    // UserDashboard class (a separate class that you should create)
    public class UserDashboard extends JFrame {
        public UserDashboard() {
            // Initialize components and layout for the user dashboard
            setTitle("User Dashboard");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            // Add components like menus, buttons, etc.
        }
    }
   

    private void createSignUpView() {
        signUpPanel.setLayout(new GridBagLayout());
    
        JTextField nameField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JTextField phoneField = new JTextField(20);
        JButton signUpButton = new JButton("Sign Up");
        JButton switchToLogin = new JButton("Back to Login");
    
        addToPanel(signUpPanel, new JLabel("Name:"), 0, 0, 1, GridBagConstraints.WEST);
        addToPanel(signUpPanel, nameField, 1, 0, 2, GridBagConstraints.CENTER);
    
        addToPanel(signUpPanel, new JLabel("Email:"), 0, 1, 1, GridBagConstraints.WEST);
        addToPanel(signUpPanel, emailField, 1, 1, 2, GridBagConstraints.CENTER);
    
        addToPanel(signUpPanel, new JLabel("Phone Number:"), 0, 2, 1, GridBagConstraints.WEST);
        addToPanel(signUpPanel, phoneField, 1, 2, 2, GridBagConstraints.CENTER);
    
        addToPanel(signUpPanel, new JLabel("Password:"), 0, 3, 1, GridBagConstraints.WEST);
        addToPanel(signUpPanel, passwordField, 1, 3, 2, GridBagConstraints.CENTER);
    
        addToPanel(signUpPanel, signUpButton, 0, 4, 1, GridBagConstraints.CENTER);
        addToPanel(signUpPanel, switchToLogin, 1, 4, 1, GridBagConstraints.CENTER);
    
        switchToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Login");
            }
        });
    
        // Add sign-up logic here for signUpButton
        // ...
    }    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginPortal().setVisible(true);
            }
        });
    }
}
