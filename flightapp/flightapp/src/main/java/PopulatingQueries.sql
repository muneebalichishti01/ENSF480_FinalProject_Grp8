-- Insert data into `users`
INSERT INTO users (username, email, phoneNumber, hasCreditCard, lastCompanionTicketSetDate, companionTicket) VALUES 
('john_doe', 'john.doe@example.com', '123-456-7890', TRUE, '2023-01-01', FALSE),
('jane_smith', 'jane.smith@example.com', '098-765-4321', FALSE, '2023-02-01', TRUE),
('alice_jones', 'alice.jones@example.com', '234-567-8901', TRUE, '2023-03-01', FALSE),
('bob_brown', 'bob.brown@example.com', '345-678-9012', FALSE, '2023-04-01', TRUE),
('charlie_black', 'charlie.black@example.com', '456-789-0123', TRUE, '2023-05-01', FALSE);

-- Insert data into `userPasswords`
INSERT INTO userPasswords (userId, passwordHash) VALUES 
(1, 'hashedPasswordJohn'),
(2, 'hashedPasswordJane'),
(3, 'hashedPasswordAlice'),
(4, 'hashedPasswordBob'),
(5, 'hashedPasswordCharlie');

-- Insert data into `flightInfo`
INSERT INTO flightInfo (flightId, flightName, destination, origin, departureDate) VALUES 
(101, 'Flight A', 'New York', 'Los Angeles', '2023-12-25'),
(102, 'Flight B', 'San Francisco', 'Chicago', '2023-12-26'),
(103, 'Flight C', 'Toronto', 'Calgary', '2024-01-03'),
(104, 'Flight D', 'Vancouver', 'Edmonton', '2023-01-01'),
(105, 'Flight E', 'Miami', 'Seattle', '2023-01-15');

-- Insert data into `aircrafts`
INSERT INTO aircrafts (aircraftId) VALUES 
(201),
(202),
(203),
(204),
(205);

-- Insert data into `passengers`
INSERT INTO passengers (flightId, name) VALUES 
(101, 'Alice Johnson'),
(102, 'Bob Brown'),
(103, 'Carol White'),
(104, 'Dave Green'),
(105, 'Eve Blue');

-- Insert data into `flightAttendants`
INSERT INTO flightAttendants (FlightAttendantId, username, name) VALUES 
(301, 'attendant1', 'Emma Wilson'),
(302, 'attendant2', 'Liam Smith'),
(303, 'attendant3', 'Olivia Brown'),
(304, 'attendant4', 'Noah Johnson'),
(305, 'attendant5', 'Sophia Davis');

-- Insert data into `flightAttendantPasswords`
INSERT INTO flightAttendantPasswords (flightAttendantId, passwordHash) VALUES 
(301, 'attendantHash1'),
(302, 'attendantHash2'),
(303, 'attendantHash3'),
(304, 'attendantHash4'),
(305, 'attendantHash5');

-- Insert data into `bookingInfo`
INSERT INTO bookingInfo (flightId, ticketPrice, cancellationInsurance) VALUES 
(101, 200.00, TRUE),
(102, 150.00, FALSE),
(103, 180.00, TRUE),
(104, 170.00, FALSE),
(105, 160.00, TRUE);

-- Insert data into `admins`
INSERT INTO admins (adminId, username) VALUES 
(401, 'admin1'),
(402, 'admin2'),
(403, 'admin3'),
(404, 'admin4'),
(405, 'admin5');

-- Insert data into `adminPasswords`
INSERT INTO adminPasswords (adminId, passwordHash) VALUES 
(401, 'adminHash1'),
(402, 'adminHash2'),
(403, 'adminHash3'),
(404, 'adminHash4'),
(405, 'adminHash5');

-- Insert data into `seats`
INSERT INTO seats (seatId, type, occupancy, flightId, booked) VALUES 
(501, 1, FALSE, 101, FALSE),
(502, 1, TRUE, 102, FALSE),
(503, 2, FALSE, 103, TRUE),
(504, 2, TRUE, 104, FALSE),
(505, 3, FALSE, 105, TRUE);
