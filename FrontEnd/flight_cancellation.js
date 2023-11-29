// Get references to HTML elements
const flightSelection = document.getElementById("flightSelection");
const cancelButton = document.getElementById("cancelButton");
const confirmationMessage = document.getElementById("confirmationMessage");

// Sample data for booked flights (you can replace this with real data)
const bookedFlights = [
    { id: "flight1", details: "Flight 1: Flight details (e.g., Flight number, date)" },
    { id: "flight2", details: "Flight 2: Flight details (e.g., Flight number, date)" },
    // Add more flights as needed
];

// Function to populate the flight selection dropdown
function populateFlightDropdown() {
    bookedFlights.forEach((flight) => {
        const option = document.createElement("option");
        option.value = flight.id;
        option.textContent = flight.details;
        flightSelection.appendChild(option);
    });
}

// Function to handle flight cancellation
function cancelFlight() {
    const selectedFlightId = flightSelection.value;

    // Find the selected flight
    const selectedFlight = bookedFlights.find((flight) => flight.id === selectedFlightId);

    if (selectedFlight) {
        // Perform cancellation logic here (e.g., remove the flight from the list)
        // You can replace this with actual cancellation code

        // Display confirmation message
        confirmationMessage.textContent = `Flight "${selectedFlight.details}" has been canceled.`;
    } else {
        confirmationMessage.textContent = "Please select a flight to cancel.";
    }
}

// Populate the flight selection dropdown when the page loads
populateFlightDropdown();

// Attach a click event listener to the Cancel Flight button
cancelButton.addEventListener("click", cancelFlight);
