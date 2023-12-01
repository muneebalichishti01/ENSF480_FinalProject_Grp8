package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import javax.swing.*;

import edu.ucalgary.oop.flightapp.logic.Database;
import jakarta.websocket.OnError; // ?? what is this

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginPortal extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private JPanel loginPanel = new JPanel(new GridBagLayout());
    private JPanel signUpPanel = new JPanel(new GridBagLayout());
    private JPanel adminLoginPanel; //added adminLogin
    private JPanel crewLoginPanel;
    private GridBagConstraints constraints = new GridBagConstraints();

    public LoginPortal() {
        initializeLoginPanel();
        initiliazeSignUpPanel();
        initializeAdminLoginPanel();
        initializeCrewLoginPanel();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(signUpPanel, "SignUp");
        getContentPane().add(mainPanel);

        setTitle("Login/Sign Up Portal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // Adjusts the frame to preferred sizes
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initializeCrewLoginPanel(){
        crewLoginPanel = new JPanel(new GridBagLayout());
        JTextField crewUsernameField = new JTextField(20);
        JPasswordField crewPasswordField = new JPasswordField(20);
        JButton crewLoginButton = new JButton("Crew Login");
        JButton switchToLogin = new JButton("Back to Login");

        addToPanel(crewLoginPanel, new JLabel("Crew Username:"), 0, 0, 1, GridBagConstraints.WEST);
        addToPanel(crewLoginPanel, crewUsernameField, 1, 0, 2, GridBagConstraints.CENTER);

        addToPanel(crewLoginPanel, new JLabel("Crew Password:"), 0, 1, 1, GridBagConstraints.WEST);
        addToPanel(crewLoginPanel, crewPasswordField, 1, 1, 2, GridBagConstraints.CENTER);

        addToPanel(crewLoginPanel, crewLoginButton, 0, 2, 1, GridBagConstraints.CENTER);
        addToPanel(crewLoginPanel, switchToLogin, 1, 2, 1, GridBagConstraints.CENTER);

        switchToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Login");
            }
        });


        crewLoginButton.addActionListener(new ActionListener() { //HERE IS THE IMPLEMENTATION TO CHECK TO CREW TABLE DB (same as the user)
            @Override
            public void actionPerformed(ActionEvent e) {
                String crewUsername = crewUsernameField.getText();
                String crewPassword = new String(crewPasswordField.getPassword());
        
                // Authenticate the crew credentials here, e.g., by querying a database
                if (crewUsername.equals("crew") && crewPassword.equals("crew123")) {
                    JOptionPane.showMessageDialog(LoginPortal.this, "Crew Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Proceed with admin actions or dashboard
                    CrewDashboard crewDashboard = new CrewDashboard();
                    crewDashboard.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginPortal.this, "Crew Login Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addCrewLoginPanel(){
        mainPanel.add(crewLoginPanel, "CrewLogin");
    }

    private void initializeAdminLoginPanel() {
        adminLoginPanel = new JPanel(new GridBagLayout());
        JTextField adminUsernameField = new JTextField(20);
        JPasswordField adminPasswordField = new JPasswordField(20);
        JButton adminLoginButton = new JButton("Admin Login");
        JButton switchToLogin = new JButton("Back to Login");

        addToPanel(adminLoginPanel, new JLabel("Admin Username:"), 0, 0, 1, GridBagConstraints.WEST);
        addToPanel(adminLoginPanel, adminUsernameField, 1, 0, 2, GridBagConstraints.CENTER);

        addToPanel(adminLoginPanel, new JLabel("Admin Password:"), 0, 1, 1, GridBagConstraints.WEST);
        addToPanel(adminLoginPanel, adminPasswordField, 1, 1, 2, GridBagConstraints.CENTER);

        addToPanel(adminLoginPanel, adminLoginButton, 0, 2, 1, GridBagConstraints.CENTER);
        addToPanel(adminLoginPanel, switchToLogin, 1, 2, 1, GridBagConstraints.CENTER);

        switchToLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Login");
            }
        });


        adminLoginButton.addActionListener(new ActionListener() { //HERE IS WHERE AUTHENTICATION FOR ADMIN GOES
            @Override
            public void actionPerformed(ActionEvent e) {
                String adminUsername = adminUsernameField.getText();
                String adminPassword = new String(adminPasswordField.getPassword());
        
                // Authenticate the admin credentials here, e.g., by querying a database
                if (adminUsername.equals("admin") && adminPassword.equals("admin123")) {
                    JOptionPane.showMessageDialog(LoginPortal.this, "Admin Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    // Proceed with admin actions or dashboard
                    AdminDashboard adminDashboard = new AdminDashboard();
                    adminDashboard.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginPortal.this, "Admin Login Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addAdminLoginPanel(){
        mainPanel.add(adminLoginPanel, "AdminLogin");
    }


    private void addToPanel(JPanel panel, Component component, int gridx, int gridy, int gridwidth, int anchor) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.anchor = anchor;
        constraints.insets = new Insets(4, 4, 4, 4); // Padding
        panel.add(component, constraints);
    }

    
    private void initializeLoginPanel() {
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton switchToSignUp = new JButton("Sign Up");
        JButton crewLogIn = new JButton("Crew Log In");
        JButton adminLogIn = new JButton("Admin Log In");
        JButton continueAsGuest =new JButton("Continue as Guest");

    
        // Adding components to the panel with grid (x, y) positions
        addToPanel(loginPanel, new JLabel("Username:"), 0, 0, 1, GridBagConstraints.WEST);
        addToPanel(loginPanel, usernameField, 1, 0, 2, GridBagConstraints.CENTER);
    
        addToPanel(loginPanel, new JLabel("Password:"), 0, 1, 1, GridBagConstraints.WEST);
        addToPanel(loginPanel, passwordField, 1, 1, 2, GridBagConstraints.CENTER);
    
        addToPanel(loginPanel, loginButton, 0, 2, 1, GridBagConstraints.CENTER);
        addToPanel(loginPanel, switchToSignUp, 1, 2, 1, GridBagConstraints.CENTER);
    
        addToPanel(loginPanel, adminLogIn, 0, 3, 1, GridBagConstraints.CENTER);
        addToPanel(loginPanel, crewLogIn, 1, 3, 1, GridBagConstraints.CENTER);
    
        addToPanel(loginPanel, continueAsGuest, 0, 4, 2, GridBagConstraints.CENTER);

        // Action listeners for the buttons
        // Add appropriate action listeners for loginButton, switchToSignUp, crewLogIn, adminLogIn
        // ...

        continueAsGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                initializeGuestDashboard();
            }
        });

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
            public void actionPerformed(ActionEvent e) {
                if (adminLoginPanel == null) {
                    initializeAdminLoginPanel(); // Initialize adminLoginPanel if not already initialized
                }
                addAdminLoginPanel(); // Add adminLoginPanel to the mainPanel
                cardLayout.show(mainPanel, "AdminLogin"); // Show the adminLoginPanel
            }
        });

        crewLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (crewLoginPanel == null){
                    initializeCrewLoginPanel();
                }
                addCrewLoginPanel();
                cardLayout.show(mainPanel, "CrewLogin");
 
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

    private void initiliazeSignUpPanel() {

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

    private void initializeGuestDashboard(){
        GuestDashboard guestDashboard = new GuestDashboard();
        guestDashboard.setVisible(true);
        dispose();
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(new Runnable() {
    //         @Override
    //         public void run() {
    //             new LoginPortal().setVisible(true);
    //         }
    //     });
    // }
}
