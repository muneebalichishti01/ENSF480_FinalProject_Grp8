-- Create schema
-- CREATE SCHEMA `flightappdatabase` ;

-- Users Table: Stores general user information
CREATE TABLE users (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(255),
    hasCreditCard BOOLEAN,
    lastCompanionTicketSetDate DATE,
    companionTicket boolean
);

-- User Passwords Table: Keeps user passwords. Ensure to store hashed passwords, not plain text
CREATE TABLE userPasswords (
    userId INT PRIMARY KEY,
    passwordHash VARCHAR(255),
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
);

-- Flight Attendants Table: Stores flight attendant information
CREATE TABLE flightAttendants (
    FlightAttendantId INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    name VARCHAR(255)
);

CREATE TABLE flightAttendantPasswords (
    flightAttendantId INT PRIMARY KEY,
    passwordHash VARCHAR(255),
    FOREIGN KEY (flightAttendantId) REFERENCES flightAttendants(FlightAttendantId)
);

-- Booking information table: Stores booking information
CREATE TABLE bookingInfo (
    bookingId INT AUTO_INCREMENT PRIMARY KEY,
    flightId INT,
    ticketPrice DECIMAL(10, 2),
    cancellationInsurance boolean,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (flightId) REFERENCES flightInfo(flightId)
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

CREATE TABLE seats (
    seatId INT,
    type INT, 
    occupancy BOOLEAN,
    flightId INT
)