-- Test queries for vieing
-- SELECT * FROM users;
-- SELECT * FROM user_passwords;
-- SELECT * FROM registered_users;

-- Users Table: Stores general user information
CREATE TABLE users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phoneNumber VARCHAR(15),
    hasCancellationInsurance BOOLEAN
);

-- Registered Users Table: Extends the users table with specific fields for registered users
CREATE TABLE registered_users (
    userId INT PRIMARY KEY,
    address VARCHAR(255),
    creditCardNumber VARCHAR(19),
    FOREIGN KEY (userId) REFERENCES users(userId)
);

-- User Passwords Table: Keeps user passwords. Ensure to store hashed passwords, not plain text
CREATE TABLE user_passwords (
    userId INT PRIMARY KEY,
    passwordHash VARCHAR(255),
    FOREIGN KEY (userId) REFERENCES users(userId)
);

-- Flights Table: Stores flight information
CREATE TABLE flights (
    flightId INT AUTO_INCREMENT PRIMARY KEY,
    flightName VARCHAR(50),
    destination VARCHAR(50),
    origin VARCHAR(50),
    departureDate DATE
);

-- Aircraft Table: Information about aircrafts
CREATE TABLE aircraft (
    aircraftId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    type VARCHAR(50)
);

-- Flight Attendants Table: Stores flight attendant information
CREATE TABLE flight_attendants (
    FlightAttendantId INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    role VARCHAR(50)
);

-- Booking information table: Stores booking information
CREATE TABLE booking_info (
    bookingId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT,
    flightId INT,
    ticketPrice DECIMAL(10, 2),
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (flightId) REFERENCES flights(flightId)
);

-- Lounge Access Table: Stores lounge access information
CREATE TABLE lounge_access (
    userId INT,
    flightId INT,
    cost DECIMAL(10, 2),
    PRIMARY KEY (userId, flightId),
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (flightId) REFERENCES flights(flightId)
);

-- Promotions Table: Stores promotion information
CREATE TABLE promotions (
    promotionId INT AUTO_INCREMENT PRIMARY KEY,
    promotionName VARCHAR(100)
);

-- Companion Tickets Table: Stores companion ticket information
CREATE TABLE companion_tickets (
    ticketId INT AUTO_INCREMENT PRIMARY KEY,
    primaryUserId INT,
    companionUserId INT,
    FOREIGN KEY (primaryUserId) REFERENCES users(userId),
    FOREIGN KEY (companionUserId) REFERENCES users(userId)
);

-- Payment Table: Stores payment information
CREATE TABLE payments (
    paymentId INT AUTO_INCREMENT PRIMARY KEY,
    userId INT,
    amount DECIMAL(10, 2),
    paymentStatus VARCHAR(50),
    FOREIGN KEY (userId) REFERENCES users(userId)
);

-- Passenger List Table: Manages passenger lists per flight
CREATE TABLE passenger_lists (
    flightId INT,
    userId INT,
    PRIMARY KEY (flightId, userId),
    FOREIGN KEY (flightId) REFERENCES flights(flightId),
    FOREIGN KEY (userId) REFERENCES users(userId)
);

-- Seat Types Table: Represents different seat types
CREATE TABLE seat_types (
    seatId INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    additionalCost DECIMAL(10, 2)
);
