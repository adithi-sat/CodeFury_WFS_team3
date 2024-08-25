document.getElementById('reportBugForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const proj_name=document.getElementById("projectName").value;
    const bug_title=document.getElementById("bugTitle").value;
    const bug_desc=document.getElementById("description").value;
    const severity=document.getElementById("severityLevel").value;
    const bug_id=document.getElementById("bugId").value;
    var isValid=true;
    const today = new Date();
    // Format the date as YYYY-MM-DD
    const formattedDate = today.toISOString().split('T')[0];

    // Set the value of the date input field
    document.getElementById('createdOn').value = formattedDate;
    document.getElementById('createdBy').value = sessionStorage.getItem("user");
    // Simulate form submission
    if(proj_name === ''){
        alert("Project name can't be empty!");
        isValid=false;
    }
    if(bug_title === ''){
        alert("Bug title can't be empty!");
        isValid=false;
    }
    if(bug_desc === ''){
        alert("Description can't be empty!");
        isValid=false;
    }
    if(severity === ''){
        alert("Severity can't be empty!");
        isValid=false;
    }
    if(bug_id === ''){
        alert("Bug id can't be empty!");
        isValid=false;
    }
    if(isValid===true){
        alert('Bug reported successfully!');
        const bugReport={
            "Proj_name": proj_name,
            "bugTitle": bug_title,
            "desc": bug_desc,
            "severity": severity,
            "bugID": bug_id,
            "createdBy": "",
            "createdOn": ""
        }
        console.log(bugReport);
        window.location.href = 'Tester.html';
    }
});
