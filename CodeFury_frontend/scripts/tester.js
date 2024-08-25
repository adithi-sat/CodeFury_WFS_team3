document.addEventListener('DOMContentLoaded', function() {
    // Simulate data fetching and rendering
    const username = 'harikrishna3512';
    const email = 'harikrishna3512@gmail.com';
    const projects = [
        { id: "automationSystem_103", name: 'New Automation System', status: "In progress",bugs: 2 },
        { id: "logisticsTracking_104", name: 'Logistics Tracking system', status:"In progress", bugs: 1 }
    ];

    document.getElementById('username').textContent += username;
    document.getElementById('email').textContent += email;
    sessionStorage.setItem("user",username);
    const projectTable = document.querySelector('tbody');
    projects.forEach(project => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${project.id}</td>
            <td>${project.name}<small> ((${project.status}))</small></td>
            <td>${project.bugs}</td>
            <td><button class="btn btn-danger" onclick="window.location.href='ReportBug.html'">Report Bug</button></td>
        `;
        projectTable.appendChild(row);
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
