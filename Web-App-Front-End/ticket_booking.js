// Get form elements and confirmation message element
const ticketBookingForm = document.getElementById('ticketBookingForm');
const bookingConfirmationMessage = document.getElementById('bookingConfirmationMessage');

// Retrieve flight details from URL parameters (you can modify this part)
const urlParams = new URLSearchParams(window.location.search);
const departureLocation = urlParams.get('departureLocation');
const destination = urlParams.get('destination');
const departureDate = urlParams.get('departureDate');
const selectedSeat = urlParams.get('selectedSeat');

// Set flight details in the form (modify input IDs if needed)
document.getElementById('departureLocation').value = departureLocation;
document.getElementById('destination').value = destination;
document.getElementById('departureDate').value = departureDate;
document.getElementById('seat').value = selectedSeat;

// Handle form submission
ticketBookingForm.addEventListener('submit', function (e) {
    e.preventDefault();

    // Perform form validation (add more validation as needed)
    const passengerName = document.getElementById('passengerName').value;
    const email = document.getElementById('email').value;
    const creditCard = document.getElementById('creditCard').value;
    const expirationDate = document.getElementById('expirationDate').value;

    if (!passengerName || !email || !creditCard || !expirationDate) {
        bookingConfirmationMessage.textContent = 'Please fill in all fields.';
        return;
    }

    // Assuming a successful booking (you can add your backend logic here)
    // Display a confirmation message
    bookingConfirmationMessage.textContent = 'Booking confirmed!';

    // Clear form fields (optional)
    ticketBookingForm.reset();
});
