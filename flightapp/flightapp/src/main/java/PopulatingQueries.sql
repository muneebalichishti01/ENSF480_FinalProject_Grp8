-- Insert data into `users`
INSERT INTO users (username, email, phoneNumber, hasCreditCard, lastCompanionTicketSetDate, companionTicket) 
VALUES 
('john_doe', 'john.doe@example.com', '123-456-7890', TRUE, '2023-01-01', FALSE),
('jane_smith', 'jane.smith@example.com', '098-765-4321', FALSE, '2023-02-01', TRUE);

-- Insert data into `userPasswords`
INSERT INTO userPasswords (userId, passwordHash) 
VALUES 
(1, 'hashedPasswordJohn'),
(2, 'hashedPasswordJane');

-- Insert data into `flightInfo`
INSERT INTO flightInfo (flightId, flightName, destination, origin, departureDate) 
VALUES 
(101, 'Flight A', 'New York', 'Los Angeles', '2023-12-25'),
(102, 'Flight B', 'San Francisco', 'Chicago', '2023-12-26'),
(201, 'Flight C', 'Toronto', 'Calgary', '2024-01-03'),
(202, 'Flight D', 'Vancouver', 'Edmonton', '2023-01-01');

-- Insert data into `aircrafts`
INSERT INTO aircrafts (aircraftId) 
VALUES 
(201),
(202);

-- Insert data into `passengers`
INSERT INTO passengers (flightId, name) 
VALUES 
(101, 'Alice Johnson'),
(102, 'Bob Brown');

-- Insert data into `flightAttendants`
INSERT INTO flightAttendants (FlightAttendantId, username, name) 
VALUES 
(301, 'attendant1', 'Emma Wilson'),
(302, 'attendant2', 'Liam Smith');

-- Insert data into `flightAttendantPasswords`
INSERT INTO flightAttendantPasswords (flightAttendantId, passwordHash) 
VALUES 
(301, 'attendantHash1'),
(302, 'attendantHash2');

-- Insert data into `bookingInfo`
INSERT INTO bookingInfo (flightId, ticketPrice, cancellationInsurance) 
VALUES 
(101, 200.00, TRUE),
(102, 150.00, FALSE);

-- Insert data into `admins`
INSERT INTO admins (adminId, username) 
VALUES 
(401, 'admin1'),
(402, 'admin2');

-- Insert data into `adminPasswords`
INSERT INTO adminPasswords (adminId, passwordHash) 
VALUES 
(401, 'adminHash1'),
(402, 'adminHash2');

-- Insert data into `seats`
INSERT INTO seats (seatId, type, occupancy, flightId, booked) 
VALUES 
(501, 1, FALSE, 101, FALSE),
(502, 1, TRUE, 102, FALSE);
