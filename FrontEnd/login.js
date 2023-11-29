document.getElementById('loginForm').addEventListener('submit', function(event){
    event.preventDefault();

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    if(username.trim() === '' || password.trim() === '') {
        alert('Please enter both username and password.');
        return false;
    }

    // Later, add AJAX request to backend for verification
    alert('Login Successful (placeholder)');
});

// Include this script in login.html
