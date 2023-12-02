package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import edu.ucalgary.oop.flightapp.logic.BookingInfo;
import edu.ucalgary.oop.flightapp.logic.FlightInfo;
import edu.ucalgary.oop.flightapp.logic.Payment;
import edu.ucalgary.oop.flightapp.logic.Seat;
import edu.ucalgary.oop.flightapp.logic.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PaymentInfoPanelUser extends JFrame {
    private FlightInfo selectedFlight;
    private Seat selectedSeat;
    private User user;
    private JTextField cardNumberField;
    private JTextField expiryDateField;
    private JTextField cvvField;
    private JCheckBox cancellationInsuranceCheckbox;
    private JCheckBox useCompanionTicketCheckbox;
    private JButton confirmPaymentButton;

    public PaymentInfoPanelUser(FlightInfo selectedFlight, Seat selectedSeat, User user) {
        this.selectedFlight = selectedFlight;
        this.selectedSeat = selectedSeat;
        this.user = user;

        setTitle("Payment Information");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        cardNumberField = new JTextField(20);
        expiryDateField = new JTextField(5);
        cvvField = new JTextField(3);
        cancellationInsuranceCheckbox = new JCheckBox("Cancellation Insurance");
        useCompanionTicketCheckbox = new JCheckBox("Use Companion Ticket");

        setupUI();

        confirmPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPayment();
            }
        });
    }

    private void setupUI() {
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Card Number:"));
        add(cardNumberField);
        add(new JLabel("Expiry Date:"));
        add(expiryDateField);
        add(new JLabel("CVV:"));
        add(cvvField);
        add(new JLabel("Add Cancellation Insurance:"));
        add(cancellationInsuranceCheckbox);
        add(new JLabel("Use Companion Ticket:"));
        add(useCompanionTicketCheckbox);

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
        boolean useCompanionTicket = useCompanionTicketCheckbox.isSelected() && user.getCompanionTicket();

        if (validatePaymentInfo(cardNumber, expiryDate, cvv)) {
            try {
                double price = Payment.calculatePrice(cancellationInsurance, selectedSeat);
                BookingInfo bookingInfo = Payment.processPayment(selectedSeat, cancellationInsurance, selectedFlight, price, user, useCompanionTicket);

                // Show ticket/receipt in a new popup window
                showTicketReceipt(bookingInfo, useCompanionTicket);

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

    private void showTicketReceipt(BookingInfo bookingInfo, boolean useCompanionTicket) {
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

        // Add companion ticket details if used
        if (useCompanionTicket) {
            Seat companionSeat = bookingInfo.getCompanionSeat();
            receiptTextArea.append("\nCompanion Seat ID: " + companionSeat.getSeatID() + "\n");
            receiptTextArea.append("Companion Seat Type: " + companionSeat.getDescription() + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        receiptFrame.add(scrollPane);
    
        receiptFrame.setVisible(true);
    }
}
