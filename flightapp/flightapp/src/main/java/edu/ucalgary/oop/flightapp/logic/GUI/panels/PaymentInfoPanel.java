package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import edu.ucalgary.oop.flightapp.logic.BookingInfo;
import edu.ucalgary.oop.flightapp.logic.FlightInfo;
import edu.ucalgary.oop.flightapp.logic.Seat;
import edu.ucalgary.oop.flightapp.logic.Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PaymentInfoPanel extends JFrame {
    private FlightInfo selectedFlight;
    private Seat selectedSeat;
    private JTextField cardNumberField;
    private JTextField expiryDateField;
    private JTextField cvvField;
    private JCheckBox cancellationInsuranceCheckbox;
    private JButton confirmPaymentButton;

    public PaymentInfoPanel(FlightInfo selectedFlight, Seat selectedSeat) {
        this.selectedFlight = selectedFlight;
        this.selectedSeat = selectedSeat;

        setTitle("Payment Information");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cardNumberField = new JTextField(20);
        expiryDateField = new JTextField(5);
        cvvField = new JTextField(3);
        cancellationInsuranceCheckbox = new JCheckBox("Cancellation Insurance");

        setupUI();

        confirmPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPayment();
            }
        });
    }

    private void setupUI() {
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Card Number:"));
        add(cardNumberField);
        add(new JLabel("Expiry Date:"));
        add(expiryDateField);
        add(new JLabel("CVV:"));
        add(cvvField);
        add(new JLabel("Add Cancellation Insurance:"));
        add(cancellationInsuranceCheckbox);

        confirmPaymentButton = new JButton("Confirm Payment");
        add(confirmPaymentButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);
    }

    private String validatePaymentInfo(String cardNumber, String expiryDate, String cvv) {
        // Check if the card number contains only digits and has a length of 16
        if (!isNumeric(cardNumber) || cardNumber.length() != 16) {
            return "Invalid card number. Please enter a 16-digit card number.";
        }
    
        // Check if the expiry date contains only digits and has a length of 4 (MMYY format)
        if (!isNumeric(expiryDate) || expiryDate.length() != 4) {
            return "Invalid expiry date. Please enter a 4-digit expiry date in MMYY format.";
        }
    
        // Check if the CVV contains only digits and has a length of 3
        if (!isNumeric(cvv) || cvv.length() != 3) {
            return "Invalid CVV. Please enter a 3-digit CVV.";
        }
    
        // All checks passed, payment information is valid
        return null; // No error message, validation successful
    }
    
    private void processPayment() {
        String cardNumber = cardNumberField.getText();
        String expiryDate = expiryDateField.getText();
        String cvv = cvvField.getText();
        boolean cancellationInsurance = cancellationInsuranceCheckbox.isSelected();
    
        String validationError = validatePaymentInfo(cardNumber, expiryDate, cvv);
        if (validationError != null) {
            JOptionPane.showMessageDialog(this, validationError, "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                double price = Payment.calculatePrice(cancellationInsurance, selectedSeat);
                BookingInfo bookingInfo = Payment.processPayment(selectedSeat, cancellationInsurance, selectedFlight, price);
    
                // Show ticket/receipt in a new popup window
                showTicketReceipt(bookingInfo);
    
                JOptionPane.showMessageDialog(this, "Payment successful! Booking confirmed. Email notification sent.");
                dispose(); // Close the panel
    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error processing payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
        
    // Helper method to check if a string contains only numeric digits
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private void showTicketReceipt(BookingInfo bookingInfo) {
        // Create a new popup window to display the ticket/receipt
        JFrame receiptFrame = new JFrame("Ticket Receipt");
        receiptFrame.setSize(400, 300);
        receiptFrame.setLocationRelativeTo(null);
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        receiptTextArea.append("Booking ID: " + bookingInfo.getBookingId() + "\n");
        receiptTextArea.append("Flight Name: " + bookingInfo.getFlightInfo().getFlightName() + "\n");
        receiptTextArea.append("Departure Date: " + bookingInfo.getFlightInfo().getDepartureDate() + "\n");
        receiptTextArea.append("Seat Type: " + bookingInfo.getSeat().getDescription() + "\n");
        receiptTextArea.append("Ticket Price: $" + bookingInfo.getTicketPrice() + "\n");
        receiptTextArea.append("Cancellation Insurance: " + (bookingInfo.getCancellationInsurance() ? "Yes" : "No") + "\n");
        // Add more booking information as needed

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        receiptFrame.add(scrollPane);

        receiptFrame.setVisible(true);
    }
}
