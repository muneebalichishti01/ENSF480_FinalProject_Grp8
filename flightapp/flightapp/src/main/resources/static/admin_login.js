document.addEventListener("DOMContentLoaded", function () {
    const adminLoginForm = document.getElementById("admin-login-form");
    const adminErrorMessage = document.querySelector(".admin-error-message");
    const adminConfirmationMessage = document.querySelector(".admin-confirmation-message");

    adminLoginForm.addEventListener("submit", function (event) {
        event.preventDefault();

        const adminUsername = document.getElementById("admin-username").value;
        const adminPassword = document.getElementById("admin-password").value;

        // Here you can add your login logic for admin
        // For now, let's just check if the username and password are not empty
        if (adminUsername.trim() === "" || adminPassword.trim() === "") {
            adminErrorMessage.textContent = "Username and password are required.";
            adminConfirmationMessage.textContent = "";
        } else {
            adminErrorMessage.textContent = "";
            adminConfirmationMessage.textContent = "Admin logged in successfully!";
        }
    });
});
