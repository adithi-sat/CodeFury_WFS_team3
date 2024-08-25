document.getElementById("registerForm").addEventListener("submit", function(event) {
    event.preventDefault();

    var name = document.getElementById("username").value;
    var id = document.getElementById("userId").value;
    var emailId = document.getElementById("emailId").value;
    var pwd1 = document.getElementById("password1").value;
    var pwd2 = document.getElementById("password").value;
    var role = document.getElementById("roleMenu").value;

    document.getElementById("nameError").textContent = "";
    document.getElementById("userIdError").textContent = "";
    document.getElementById("emailIdError").textContent = "";
    document.getElementById("password1Error").textContent = "";
    document.getElementById("passwordError").textContent = "";
    document.getElementById("roleError").textContent = "";

    let isValid = true;

    if (name === "" || name === null) {
        document.getElementById("nameError").textContent = "Name is required";
        isValid = false;
    }
    if (id === "" || id === null) {
        document.getElementById("userIdError").textContent = "User ID is required";
        isValid = false;
    }

    const mailRegex = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-z]{2,3}$/;
    if (!mailRegex.test(emailId)) {
        document.getElementById("emailIdError").textContent = "Enter a valid email";
        isValid = false;
    }

    if (pwd1 === "") {
        document.getElementById("password1Error").textContent = "Password is required.";
        isValid = false;
    }

    if (pwd1 !== pwd2) {
        document.getElementById("passwordError").textContent = "Passwords don't match";
        isValid = false;
    }

    if (role === "") {
        document.getElementById("roleError").textContent = "Please select a role.";
        isValid = false;
    }

    if (isValid) {
        alert("Registered successfully!");
        window.location.href='login.html';
    }
});
