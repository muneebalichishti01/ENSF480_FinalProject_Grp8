-- Insert sample data into 'users' table
INSERT INTO users (username, email, phoneNumber, hasCancellationInsurance) VALUES 
('johndoe', 'john.doe@example.com', '123-456-7890', TRUE),
('janedoe', 'jane.doe@example.com', '987-654-3210', FALSE);

-- Insert sample data into 'registeredUsers' table
INSERT INTO registeredUsers (userId, address, creditCardNumber, loungeAccessId, promotionId, companionTicketId, lastCompanionTicketSetDate) VALUES 
(1, '123 Main St, Anytown, AT 12345', '1111222233334444', 1, 1, 1, '2023-01-01'),
(2, '456 Elm St, Othertown, OT 67890', '5555666677778888', 2, 2, 2, '2023-01-02');

-- Insert sample data into 'userPasswords' table
-- Note: Passwords should be hashed in a real application
INSERT INTO userPasswords (userId, passwordHash) VALUES 
(1, 'hashedpassword1'),
(2, 'hashedpassword2');

-- Insert sample data into 'creditCards' table
INSERT INTO creditCards (userId, cardNumber, expiryDate, cvv) VALUES 
(1, '1111222233334444', '2025-12', '123'),
(2, '5555666677778888', '2026-06', '456');

-- Insert sample data into 'flightInfo' table
INSERT INTO flightInfo (flightId, flightName, destination, origin, departureDate) VALUES 
(1, 'Flight A101', 'New York', 'Los Angeles', '2023-12-15'),
(2, 'Flight B202', 'Chicago', 'Miami', '2023-12-20');

-- Insert sample data into 'aircrafts' table
INSERT INTO aircrafts (aircraftId, name) VALUES 
(1, 'Boeing 737'),
(2, 'Airbus A320');

-- Insert sample data into 'flightAttendants' table
INSERT INTO flightAttendants (FlightAttendantId, name, username) VALUES 
(1, 'Alice Smith', 'asmith'),
(2, 'Bob Johnson', 'bjohnson');

-- Insert sample data into 'flightAttendantPasswords' table
-- Note: Passwords should be hashed in a real application
INSERT INTO flightAttendantPasswords (flightAttendantId, passwordHash) VALUES 
(1, 'hashedpassword1'),
(2, 'hashedpassword2');

-- Insert sample data into 'bookingInfo' table
INSERT INTO bookingInfo (bookingId, userId, flightId, ticketPrice) VALUES 
(1, 1, 1, 300.00),
(2, 2, 2, 450.00);

-- Insert sample data into 'payments' table
INSERT INTO payments (paymentId, userId, amount, paymentStatus) VALUES 
(1, 1, 300.00, 'Completed'),
(2, 2, 450.00, 'Pending');

-- Insert sample data into 'admins' table
INSERT INTO admins (adminId, username) VALUES 
(1, 'admin1'),
(2, 'admin2');

-- Insert sample data into 'adminPasswords' table
-- Note: Passwords should be hashed in a real application
INSERT INTO adminPasswords (adminId, passwordHash) VALUES 
(1, 'adminpassword1'),
(2, 'adminpassword2');
