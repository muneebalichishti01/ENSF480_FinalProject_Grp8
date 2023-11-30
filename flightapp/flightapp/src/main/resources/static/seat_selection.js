// Sample list of available seats for the flight (you can replace this with actual data)
const availableSeats = ["A1", "A2", "B1", "B2", "C1", "C2", "D1", "D2"];

// Function to display available seats in the form
function displayAvailableSeats() {
    const seatSelectionForm = document.getElementById("seatSelectionForm");
    
    // Clear the existing seat options
    while (seatSelectionForm.lastChild) {
        seatSelectionForm.removeChild(seatSelectionForm.lastChild);
    }
    
    // Create a label and select input for each available seat
    availableSeats.forEach((seat) => {
        const label = document.createElement("label");
        label.innerText = seat;
        
        const input = document.createElement("input");
        input.type = "radio";
        input.name = "selectedSeat";
        input.value = seat;
        
        seatSelectionForm.appendChild(label);
        seatSelectionForm.appendChild(input);
    });
}

// Function to confirm seat selection
function confirmSeatSelection() {
    const seatSelectionForm = document.getElementById("seatSelectionForm");
    const selectedSeat = document.querySelector('input[name="selectedSeat"]:checked');
    const seatSelectionMessage = document.getElementById("seatSelectionMessage");

    if (selectedSeat) {
        const confirmationMessage = `Seat ${selectedSeat.value} has been selected.`;
        seatSelectionMessage.innerText = confirmationMessage;
    } else {
        seatSelectionMessage.innerText = "Please select a seat.";
    }
}

// Display available seats when the page loads
window.addEventListener("load", displayAvailableSeats);
