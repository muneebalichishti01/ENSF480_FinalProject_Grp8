package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import edu.ucalgary.oop.flightapp.logic.Database;
import edu.ucalgary.oop.flightapp.logic.BookingInfo;
import edu.ucalgary.oop.flightapp.logic.FlightInfo;
import edu.ucalgary.oop.flightapp.logic.Seat;

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

    private void processPayment() {
        String cardNumber = cardNumberField.getText();
        String expiryDate = expiryDateField.getText();
        String cvv = cvvField.getText();
        boolean cancellationInsurance = cancellationInsuranceCheckbox.isSelected();

        if (validatePaymentInfo(cardNumber, expiryDate, cvv)) {
            try {
                // Assuming booking ID is auto-generated or calculated
                int bookingId = generateBookingId(); // Implement this method as per your logic

                BookingInfo bookingInfo = new BookingInfo(
                    bookingId,
                    selectedFlight,
                    selectedSeat.getCost(), // Price derived from seat type
                    selectedSeat,
                    cancellationInsurance
                );

                // Record the booking in the database
                Database.createBooking(bookingInfo);

                JOptionPane.showMessageDialog(this, "Payment successful! Booking confirmed. Email notification sent.");
                dispose(); // Close the panel

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error processing payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid payment details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validatePaymentInfo(String cardNumber, String expiryDate, String cvv) {
        // Implement actual validation logic for payment information
        return !cardNumber.isEmpty() && !expiryDate.isEmpty() && !cvv.isEmpty();
    }

    private int generateBookingId() {
        // Implement logic to generate or retrieve a booking ID
        // This could involve querying the database or an internal application logic
        return 0; // Placeholder value
    }
}
