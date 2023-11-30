// JavaScript code for the User Dashboard

// Function to display a welcome message
function displayWelcomeMessage() {
    const userWelcome = document.getElementById('user-welcome');
    userWelcome.textContent = 'Welcome, User!';
}

// Add event listeners to dashboard options
document.addEventListener('DOMContentLoaded', () => {
    // Display welcome message
    displayWelcomeMessage();

    // Dashboard options
    const flightSearchLink = document.getElementById('flight-search-link');
    const ticketBookingLink = document.getElementById('ticket-booking-link');
    const companionTicketsLink = document.getElementById('companion-tickets-link');
    const promotionsLink = document.getElementById('promotions-link');
    const loungeAccessLink = document.getElementById('lounge-access-link');

    // Add event listeners to navigate to respective functionalities
    flightSearchLink.addEventListener('click', () => {
        window.location.href = 'flight_search.html';
    });

    ticketBookingLink.addEventListener('click', () => {
        window.location.href = 'ticket_booking.html';
    });

    companionTicketsLink.addEventListener('click', () => {
        window.location.href = 'companion_ticket.html';
    });

    promotionsLink.addEventListener('click', () => {
        window.location.href = 'promotions.html';
    });

    loungeAccessLink.addEventListener('click', () => {
        window.location.href = 'lounge_access.html';
    });
});
