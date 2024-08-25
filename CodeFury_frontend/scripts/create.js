developers=[
    {
        "id": "DEV-16",
        "name": "Abhishek"
    },
    {
        "id": "DEV-18",
        "name": "Twesha"
    },
    {
        "id": "DEV-10",
        "name": "Mahesh"
    }
];
document.getElementById("manager").value=sessionStorage.getItem("user");
document.getElementById("status").value="In progress";
document.getElementById('create-project-form').addEventListener('submit', function(event) {
    // Prevent form submission
    event.preventDefault();
    // Get form field values
    const prid = document.getElementById('prid').value.trim();
    const name = document.getElementById('name').value.trim();
    const manager = document.getElementById('manager').value.trim();
    const startdate = document.getElementById('startdate').value;
    const team = document.getElementById('team').value.trim();
    const dev = document.getElementById('dev').value;
    const tester = document.getElementById('tester').value;
    const status = document.getElementById('status').value;

    // Initialize error messages
    let errorMessage = '';

    // Validate Project ID
    if (prid === '') {
        errorMessage += 'Project ID is required.\n';
    }

    // Validate Project Name
    if (name === '') {
        errorMessage += 'Project Name is required.\n';
    }

    // Validate Manager
    if (manager === '') {
        errorMessage += 'Manager is required.\n';
    }

    // Validate Start Date
    if (startdate === '') {
        errorMessage += 'Start Date is required.\n';
    }

    // Validate Team
    if (team === '') {
        errorMessage += 'Team is required.\n';
    }

    // Validate Developer ID
    if (dev === '') {
        errorMessage += 'Please select a Developer ID.\n';
    }

    // Validate Tester ID
    if (tester === '') {
        errorMessage += 'Please select a Tester ID.\n';
    }

    // Validate Status
    if (status === '') {
        errorMessage += 'Please select a Status.\n';
    }

    // If there's an error, alert the user
    if (errorMessage !== '') {
        alert(errorMessage);
    } else {
        // If no error, submit the form
        alert("Project created successfully!");
        const projectCreated={
            "pr_id": prid,
            "Proj_name": name,
            "Manager":manager,
            "start-date":startdate,
            "team": team,
            "developer": dev,
            "tester": tester,
            "status": status
        };
        console.log(projectCreated);
    }
});


function signOut() {
    if (confirm("Are you sure you want to sign out?")) {
        alert("You have successfully signed out.");
        window.location.href = "login.html";
    } else {
        alert("Sign out canceled.");
    }
}
