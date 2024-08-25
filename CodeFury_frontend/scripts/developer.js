
document.addEventListener('DOMContentLoaded', function () {
    const username = 'Abhishek45';
    const email = 'abhishek45@gmail.com';
    const projects = [
        { id: "automationSystem_103", name: 'New Automation System', status: "In progress",bugs: 2 },
        { id: "logisticsTracking_104", name: 'Logistics Tracking system', status:"In progress", bugs: 1 }
    ];

    document.getElementById('username').textContent = username;
    document.getElementById('email').textContent = email;
       document.querySelectorAll('.btn-success').forEach(button => {
        button.addEventListener('click', function () {
          
            const bugItem = this.closest('.list-group-item');
            bugItem.remove();
        });
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
