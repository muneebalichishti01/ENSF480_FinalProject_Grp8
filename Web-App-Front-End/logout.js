// logout.js

// Function to log the user out
function logout() {
    // Clear user session or any other necessary logout actions
    // For demonstration purposes, we'll simply redirect to the login page
    window.location.href = "login.html";
  }
  
  // Add an event listener to the logout button or link
  document.addEventListener("DOMContentLoaded", function () {
    const logoutButton = document.getElementById("logoutButton"); // Replace with the actual ID of the logout button/link
  
    if (logoutButton) {
      // Check if the logout button/link exists on the current page
      logoutButton.addEventListener("click", function (event) {
        event.preventDefault(); // Prevent the default behavior of the link (optional)
        logout(); // Call the logout function
      });
    }
  });
  