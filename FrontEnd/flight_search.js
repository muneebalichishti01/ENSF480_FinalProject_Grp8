// Selecting the form element
const flightSearchForm = document.getElementById('flightSearchForm');

// Selecting the search results container
const searchResultsContainer = document.getElementById('searchResults');

// Function to handle form submission
flightSearchForm.addEventListener('submit', async (event) => {
    event.preventDefault(); // Prevent the default form submission
    
    // Get values from form inputs
    const departureLocation = document.getElementById('departureLocation').value;
    const destination = document.getElementById('destination').value;
    const departureDate = document.getElementById('departureDate').value;
    const passengerCount = document.getElementById('passengerCount').value;
    
    // You can perform validation here if needed
    
    // Send a request to the server to fetch flight search results
    const searchResults = await fetchFlightSearchResults(departureLocation, destination, departureDate, passengerCount);
    
    // Display the search results
    displaySearchResults(searchResults);
});

// Function to fetch flight search results from the server
async function fetchFlightSearchResults(departureLocation, destination, departureDate, passengerCount) {
    // You can use fetch() or another library to send a request to the server
    // Example: const response = await fetch('api/flight/search', { method: 'POST', body: JSON.stringify({ departureLocation, destination, departureDate, passengerCount }) });
    // Replace the above line with your actual API request
    
    // For now, let's simulate search results
    const mockResults = [
        { flightNumber: 'ABC123', departure: 'City A', destination: 'City B', departureTime: '08:00 AM', arrivalTime: '10:00 AM', price: '$200' },
        { flightNumber: 'XYZ456', departure: 'City B', destination: 'City C', departureTime: '11:00 AM', arrivalTime: '01:00 PM', price: '$250' },
        // Add more flight objects here as needed
    ];

    return mockResults;
}

// Function to display search results on the page
function displaySearchResults(results) {
    // Clear any previous search results
    searchResultsContainer.innerHTML = '';

    if (results.length === 0) {
        // No flights found
        searchResultsContainer.innerHTML = '<p>No flights found.</p>';
    } else {
        // Display flight details
        results.forEach((result) => {
            const flightElement = document.createElement('div');
            flightElement.classList.add('flight-details');
            flightElement.innerHTML = `
                <p>Flight Number: ${result.flightNumber}</p>
                <p>Departure: ${result.departure}</p>
                <p>Destination: ${result.destination}</p>
                <p>Departure Time: ${result.departureTime}</p>
                <p>Arrival Time: ${result.arrivalTime}</p>
                <p>Price: ${result.price}</p>
            `;
            searchResultsContainer.appendChild(flightElement);
        });
    }
}
