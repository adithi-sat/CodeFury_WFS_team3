
document.getElementById('downloadUsers').addEventListener('click', function() {
const users=[
    {
        "id": "Sowbhagya24",
        "name": "Sowbhagya",
        "email": "pothinenisowbhagya@gmail.com",
        "role": "Developer"
    },
    {
        "id": "Adithi143",
        "name": "Adithi",
        "email": "Adithi@gmail.com",
        "role": "Tester"
    },
    {
        "id": "Srinivas53",
        "name": "Srinivas",
        "email": "Srinivas@hsbc.co.in",
        "role": "Project Manager"
    }
];
const jsonData = JSON.stringify(users, null, 2);

    // Create a Blob from the JSON string
    const blob = new Blob([jsonData], { type: 'application/json' });

    // Create a link element
    const link = document.createElement('a');

    // Set the download attribute with a filename
    link.download = 'users.json';

    // Create a URL for the Blob and set it as the href attribute
    link.href = URL.createObjectURL(blob);

    // Append the link to the body (required for Firefox)
    document.body.appendChild(link);

    // Programmatically click the link to trigger the download
    link.click();

    // Remove the link after the download
    document.body.removeChild(link);
});
