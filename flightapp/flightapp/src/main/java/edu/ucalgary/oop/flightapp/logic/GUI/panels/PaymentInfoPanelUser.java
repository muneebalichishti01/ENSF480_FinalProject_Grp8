package edu.ucalgary.oop.flightapp.logic.GUI.panels;

import edu.ucalgary.oop.flightapp.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentInfoPanelUser extends JFrame {
    private FlightInfo selectedFlight;
    private Seat selectedSeat;
    private User user;  // User object
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
                BookingInfo bookingInfo = Payment.processPayment(selectedSeat, cancellationInsurance, selectedFlight, price);

                Seat companionSeat = null;
                if (useCompanionTicket) {
                    companionSeat = findAvailableSeat(selectedFlight);
                    if (companionSeat != null) {
                        user.useCompanionTicket(); // Update the companion ticket status
                        Database.updateUser(user); // Save changes to the user
                    }
                }

                showTicketReceipt(bookingInfo, companionSeat);

                JOptionPane.showMessageDialog(this, "Payment successful! Booking confirmed. Email notification sent.");
                dispose();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error processing payment: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid payment details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validatePaymentInfo(String cardNumber, String expiryDate, String cvv) {
        // Validation logic here
        return !cardNumber.isEmpty() && !expiryDate.isEmpty() && !cvv.isEmpty();
    }

    private Seat findAvailableSeat(FlightInfo flightInfo) {
        // Implement logic to find an available seat
        ArrayList<Seat> seats = Database.browseSeats(flightInfo.getFlightId());
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                return seat;
            }
        }
        return null; // or handle no available seats case
    }

    private void showTicketReceipt(BookingInfo bookingInfo, Seat companionSeat) {
        // Create a new popup window to display the ticket/receipt
        JFrame receiptFrame = new JFrame("Ticket Receipt");
        receiptFrame.setSize(400, 300);
        receiptFrame.setLocationRelativeTo(null);
        receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        receiptTextArea.append("Booking ID: " + bookingInfo.getBookingId() + "\n");
        // Add more details of bookingInfo
        if (companionSeat != null) {
            receiptTextArea.append("\nCompanion Seat ID: " + companionSeat.getSeatID() + "\n");
            // Add more details of companionSeat
        }

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        receiptFrame.add(scrollPane);

        receiptFrame.setVisible(true);
    }
}
