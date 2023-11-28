document.addEventListener("DOMContentLoaded", function () {
    const crewLoginForm = document.getElementById("crew-login-form");
    const crewErrorMessage = document.querySelector(".crew-error-message");
    const crewConfirmationMessage = document.querySelector(".crew-confirmation-message");

    crewLoginForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const crewUsername = document.getElementById("crew-username").value;
        const crewPassword = document.getElementById("crew-password").value;

        // Here you can add your login logic for crew members
        // For now, let's just check if the username and password are not empty
        if (crewUsername.trim() === "" || crewPassword.trim() === "") {
            crewErrorMessage.textContent = "Username and password are required.";
            crewConfirmationMessage.textContent = "";
        } else {
            crewErrorMessage.textContent = "";
            crewConfirmationMessage.textContent = "Crew member logged in successfully!";
        }
    });
});
