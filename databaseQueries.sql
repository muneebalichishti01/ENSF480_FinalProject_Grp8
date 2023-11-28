-- User Table
CREATE TABLE User (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Email VARCHAR(255) UNIQUE,
    Phone VARCHAR(20),
    MembershipStatus ENUM('Registered User', 'Flight Attendant'),
    CreditCardInfo VARCHAR(255),
    CompanionTicketEligibility BOOLEAN
);

-- Aircraft Table
CREATE TABLE Aircraft (
    AircraftID INT AUTO_INCREMENT PRIMARY KEY,
    AircraftType VARCHAR(255),
    Capacity INT,
    AvailableSeats INT
);

-- Flight Table
CREATE TABLE Flight (
    FlightID INT AUTO_INCREMENT PRIMARY KEY,
    FlightName VARCHAR(255),
    Origin VARCHAR(255),
    Destination VARCHAR(255),
    DepartureDate DATE,
    AircraftUsed INT,
    FOREIGN KEY (AircraftUsed) REFERENCES Aircraft(AircraftID)
);

-- Crew Table
CREATE TABLE Crew (
    CrewID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    Position VARCHAR(255),
    FlightID INT,
    FOREIGN KEY (FlightID) REFERENCES Flight(FlightID)
);



-- Booking Info Table
CREATE TABLE BookingInfo (
    BookingID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    FlightID INT,
    SeatType ENUM('Ordinary', 'Comfort', 'Business'),
    SeatNumber INT,
    InsuranceOptIn BOOLEAN,
    TotalCost DECIMAL(10, 2),
    PaymentInfo VARCHAR(255),
    Receipt VARCHAR(255),
    CancellationStatus BOOLEAN,
    FOREIGN KEY (UserID) REFERENCES User(UserID),
    FOREIGN KEY (FlightID) REFERENCES Flight(FlightID)
);

-- Promotions Table
CREATE TABLE Promotions (
    PromotionID INT AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(255),
    Description TEXT,
    EmailRecipients VARCHAR(255)
);

-- Lounge Access Table
CREATE TABLE LoungeAccess (
    LoungeID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    PaymentInfo VARCHAR(255),
    AccessStatus BOOLEAN,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

-- Companion Ticket Table
CREATE TABLE CompanionTicket (
    CompanionTicketID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    UsageStatus BOOLEAN,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);
