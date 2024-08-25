
const projects = {
    "HospitalMgmt_101": {
        name: "Hospital Management",
        status: "In progress",
        bugs: [
            { id: "BUG001", title: "Issue with patient records", description: "Unable to access patient records due to server error.", securityLevel: "High" },
            { id: "BUG002", title: "Error in appointment scheduling", description: "Appointments are not being saved correctly.", securityLevel: "Medium" },
            { id: "BUG003", title: "Data loss in discharge summary", description: "Discharge summaries are missing critical information.", securityLevel: "Critical" },
            { id: "BUG004", title: "Incorrect medication alerts", description: "Alerts for medication interactions are not functioning.", securityLevel: "High" }
        ]
    },
    "BugTracking_102": {
        name: "Bug Tracking System",
        status: "In progress",
        bugs: [
            { id: "BUG001", title: "Login Issue", description: "Users are unable to log in with valid credentials.", securityLevel: "Critical" },
            { id: "BUG002", title: "Page Load Delay", description: "Significant delay when loading the dashboard.", securityLevel: "Medium" },
            { id: "BUG003", title: "Incorrect Data Display", description: "Data displayed is not matching the database records.", securityLevel: "High" },
            { id: "BUG004", title: "Email Notification Failure", description: "Email notifications are not being sent for new bugs.", securityLevel: "Medium" }
        ]
    }
};

const urlParams = new URLSearchParams(window.location.search);
const projectId = urlParams.get('projectId');

if (projects[projectId]) {
    const project = projects[projectId];
    const projectInfoDiv = document.getElementById("projectInfo");
    projectInfoDiv.innerHTML = `
        <h3>Project Name: ${project.name}</h3>
        <p><strong>Project ID:</strong> ${projectId}</p>
        <p><strong>Status:</strong> ${project.status}</p>
    `;

    const bugListDiv = document.getElementById("bugs");
    project.bugs.forEach(bug => {
        const li = document.createElement("li");
        li.className = "list-group-item";
        li.innerHTML = `
            <strong>Bug ID:</strong> ${bug.id} <br>
            <strong>Title:</strong> ${bug.title} <br>
            <strong>Description:</strong> ${bug.description} <br>
            <strong>Security Level:</strong> ${bug.securityLevel}
        `;
        bugListDiv.appendChild(li);
    });
} else {
    document.getElementById("projectInfo").innerHTML = "<p>Project not found.</p>";
}

function signOut() {
    if (confirm("Are you sure you want to sign out?")) {
        alert("You have successfully signed out.");
        window.location.href = "login.html";
    } else {
        alert("Sign out canceled.");
    }
}
