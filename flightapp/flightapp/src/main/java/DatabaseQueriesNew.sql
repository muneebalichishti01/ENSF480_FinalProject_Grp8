-- Create schema
-- CREATE SCHEMA `flightappdatabase` ;

-- Users Table: Stores general user information
CREATE TABLE users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(255),
    hasCancellationInsurance BOOLEAN
);

-- Registered Users Table: Extends the users table with specific fields for registered users
CREATE TABLE registeredUsers (
    userId INT PRIMARY KEY,
    address VARCHAR(255),
    creditCardNumber VARCHAR(255),
    loungeAccessId INT,
    promotionId INT,
    companionTicketId INT,
    FOREIGN KEY (userId) REFERENCES users(userId),
    lastCompanionTicketSetDate DATE
);

-- User Passwords Table: Keeps user passwords. Ensure to store hashed passwords, not plain text
CREATE TABLE userPasswords (
    userId INT PRIMARY KEY,
    passwordHash VARCHAR(255),
    FOREIGN KEY (userId) REFERENCES users(userId)
);

-- Credit Cards Table: Stores credit card information
CREATE TABLE creditCards (
    userId INT,
    cardNumber VARCHAR(255) NOT NULL,
    expiryDate VARCHAR(255) NOT NULL,
    cvv VARCHAR(255) NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(userId)
);

-- Flights Table: Stores flight information
CREATE TABLE flightInfo (
    flightId INT PRIMARY KEY,
    flightName VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    origin VARCHAR(255) NOT NULL,
    departureDate DATE NOT NULL
);

-- Aircraft Table: Information about aircrafts
CREATE TABLE aircrafts (
    aircraftId INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Flight Attendants Table: Stores flight attendant information
CREATE TABLE flightAttendants (
    FlightAttendantId INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE flightAttendantPasswords (
    flightAttendantId INT PRIMARY KEY,
    passwordHash VARCHAR(255),
    FOREIGN KEY (flightAttendantId) REFERENCES flightAttendants(FlightAttendantId)
);

-- Booking information table: Stores booking information
CREATE TABLE bookingInfo (
    bookingId INT PRIMARY KEY,
    userId INT,
    flightId INT,
    ticketPrice DECIMAL(10, 2),
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (flightId) REFERENCES flightInfo(flightId)
);

-- Payment Table: Stores payment information
CREATE TABLE payments (
    paymentId INT PRIMARY KEY,
    userId INT,
    amount DECIMAL(10, 2),
    paymentStatus VARCHAR(255),
    companionTicketId INT,
    primaryUserId INT,
    companionUserId INT,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (primaryUserId) REFERENCES users(userId),
    FOREIGN KEY (companionUserId) REFERENCES users(userId)
);

-- Seat Types Table: Represents different seat types
-- Can remove this table
CREATE TABLE seatTypes (        
    seatTypeId INT PRIMARY KEY,
    description VARCHAR(255),
    cost DECIMAL(10, 2),
    flightId INT
);

CREATE TABLE admins (
    adminId INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL
);

CREATE TABLE adminPasswords (
    adminId INT PRIMARY KEY,
    passwordHash VARCHAR(255),
    FOREIGN KEY (adminId) REFERENCES admins(adminId)
);
