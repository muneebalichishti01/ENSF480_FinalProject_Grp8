document.getElementById('registerForm').addEventListener('submit', function(event){
    if (!validateForm()) {
        event.preventDefault();
    }
});

function validateForm() {
    var fullname = document.getElementById('fullname').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    var membershipType = document.querySelector('input[name="membershipType"]:checked').value;
    var validationMessage = '';

    if(fullname.trim() === '') {
        validationMessage += 'Full Name is required.\n';
    }
    if(email.trim() === '') {
        validationMessage += 'Email is required.\n';
    }
    if(password.trim() === '') {
        validationMessage += 'Password is required.\n';
    }
    if(confirmPassword.trim() === '') {
        validationMessage += 'Confirm Password is required.\n';
    }
    if(password !== confirmPassword) {
        validationMessage += 'Passwords do not match.\n';
    }

    if(validationMessage) {
        alert(validationMessage);
        return false; // Validation failed
    } else {
        alert('Registration Successful as ' + (membershipType === 'premium' ? 'Premium' : 'Regular') + ' Member (placeholder)');
        return true; // Validation succeeded
    }
}
