// script.js
const loginForm = document.getElementById('loginForm');

loginForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                // Handle successful login (e.g., redirect to the main page)
                window.location.href = '/home';
            } else {
                // Display an error message
                alert('Login failed.');
            }
        })
        .catch(error => {
            console.error(error);
            alert('An error occurred. Please try again.');
        });
});
