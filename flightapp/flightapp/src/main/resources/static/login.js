document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    if (username.trim() === '' || password.trim() === '') {
        alert('Please enter both username and password.');
        return false;
    }

    // AJAX request to backend
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/login.html", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    
    xhr.onreadystatechange = function() {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            // Redirect to user dashboard on successful login
            window.location.href = "/userDashboard";
        } else if (this.readyState === XMLHttpRequest.DONE) {
            // Handle login failure
            alert('Login failed: Invalid username or password');
        }
    }

    // Send the request with username and password
    xhr.send("username=" + encodeURIComponent(username) + "&password=" + encodeURIComponent(password));
});
