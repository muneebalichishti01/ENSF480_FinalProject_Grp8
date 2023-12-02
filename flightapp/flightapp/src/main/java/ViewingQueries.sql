-- Test queries for viewing
-- SELECT * FROM users;
-- SELECT * FROM userPasswords;
-- SELECT * FROM registeredUsers;

-- Query to view users' details with their password hash
SELECT u.userId, u.username, u.email, u.phoneNumber, u.hasCancellationInsurance, up.passwordHash
FROM users u
JOIN userPasswords up ON u.userId = up.userId;

-- Query to view data in 'users' table
SELECT * FROM users;

-- Query to view data in 'registeredUsers' table
SELECT * FROM registeredUsers;

-- Query to view data in 'userPasswords' table
SELECT * FROM userPasswords;

-- Query to view data in 'creditCards' table
SELECT * FROM creditCards;

-- Query to view data in 'flightInfo' table
SELECT * FROM flightInfo;

-- Query to view data in 'aircrafts' table
SELECT * FROM aircrafts;

-- Query to view data in 'flightAttendants' table
SELECT * FROM flightAttendants;

-- Query to view data in 'flightAttendantPasswords' table
SELECT * FROM flightAttendantPasswords;

-- Query to view data in 'bookingInfo' table
SELECT * FROM bookingInfo;

-- Query to view data in 'payments' table
SELECT * FROM payments;

-- Query to view data in 'admins' table
SELECT * FROM admins;

-- Query to view data in 'adminPasswords' table
SELECT * FROM adminPasswords;


