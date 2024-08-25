const projects = [
    { id: "HospitalMgmt_101", name: "Hospital Management", status: "In progress" },
    { id: "BugTracking_102", name: "Bug Tracking System", status: "In progress" },    
];

document.addEventListener("DOMContentLoaded", function() {
    const projectListDiv = document.getElementById("project-list");
    document.getElementById("welcome").textContent="Welcome "+sessionStorage.getItem("user");
    document.getElementById("username").textContent="Username: "+sessionStorage.getItem("user");
    projects.forEach(project => {
        const projectCard = document.createElement("div");
        projectCard.className = "card project-card";
        projectCard.onclick = () => window.location.href = `ProjDetails.html?projectId=${project.id}`;

        const cardBody = document.createElement("div");
        cardBody.className = "card-body";

        const cardTitle = document.createElement("h5");
        cardTitle.className = "card-title";
        cardTitle.textContent = `PR ID: ${project.id}`;

        const cardText = document.createElement("p");
        cardText.className = "card-text";
        cardText.textContent = `Project Name: ${project.name}`;

        const cardStatus = document.createElement("p");
        cardStatus.className = "card-status";
        cardStatus.textContent = `Status: ${project.status}`;

        cardBody.appendChild(cardTitle);
        cardBody.appendChild(cardText);
        cardBody.appendChild(cardStatus);
        projectCard.appendChild(cardBody);
        projectListDiv.appendChild(projectCard);
    });
});

function signOut() {
    if (confirm("Are you sure you want to sign out?")) {
        alert("You have successfully signed out.");
        window.location.href = "login.html";
    } else {
        alert("Sign out canceled.");
    }
}