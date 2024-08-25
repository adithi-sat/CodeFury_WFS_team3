

# BUG TRACKING SYSTEM

## Aim

The project is an online bug-tracking system for projects. The application allows software testers to report bugs for a project, project managers to view all bugs, and assign bugs to developers and developers to update the bug status.

### System Requirements:

 >Hardware Requirements

-   Operating system: Windows, Linux or MacOS
-   Processor: intel core i5 or equivalent
-   At least 4GB of RAM
-   At least 10GB of free storage space
-   Graphics card: NVIDIA GeForce GTX 1050 or equivalent

>Software Requirements

-   Visual studio code/IntelliJ IDEA
-   Google Chrome/Mozilla Firefox/Microsoft Edge
-   Live Server extension in VS Code

### Procedure

In the application, the project is divided into two main folders.

1. **Frontend**

2. **Backend**

The **Frontend** folder contains all the components related to the user interface and client-side logic. This typically includes HTML files for structure, CSS files for styling, and JavaScript files for handling dynamic behavior and interactivity on the client side. The front end is responsible for rendering the user interface, handling user input, and communicating with the back end to retrieve or send data. It also includes assets like images and Bootstrap for styling.

On the other hand, the **Backend** folder is where the server-side logic resides. This includes code that handles data processing, business logic, and interactions with the database. The back end is responsible for managing requests.

In the Front-End Folder, there are 4 Sub-folders

- Templates

- Static

- Images

- Scripts

- JSON.

> **Templates** 
 The templates folder includes various HTML files, such as BugTrackingMain.html, ProjManager.html, and login.html, etc which define the structure of the application's different web pages. HTML files serve as the backbone of a web project, structuring the content and layout of the web pages displayed in a browser.
 
> **Static**
The static folder contains CSS stylesheets corresponding to various pages or components, such as create.css, developer.css, login.css, MainPage.css, ProjDetails.css, and ProjManager.css. In the application, Bootstrap is preloaded for styling.
CSS files, along with Bootstrap, are used in the project to enhance the visual presentation and styling of web pages, ensuring a responsive and aesthetically pleasing design.

>**Images**
In the Images folder, we have all types of images used in the project.

>**Scripts**
The scripts folder contains JavaScript files such as create.js, developer.js, login.js, ProjDetails.js, ProjManager.js, register.js, reportBug.js, and tester.js, each responsible for specific functionalities like project management, user registration, and bug reporting.
JavaScript is used to add interactivity and dynamic content to web pages, enabling features like form validations and asynchronous data loading.

The entry point of the application is the **Bug Tracking System's main page**. After registering on the website, users can log in, which by default takes them to the Project Manager page. In the Project Manager page, users can create new projects and assign them to developers or testers by clicking on "Create Project." The Project Manager can also view bugs in a project by clicking on the specific project. Additionally, there are separate HTML pages for developers and testers, with the tester page linked to the "Report Bug" functionality, as only testers can report bugs. Upon connecting the front end and back end, we can load specific user roles, such as project manager, developer, and tester, based on our requirements.

**Run the Project Application**
1. To run the project, first clone the repository from GitHub using the command git clone  https://github.com/adithi-sat/CodeFury_WFS_team3.git

2. And then, open your project folder in Visual Studio Code by selecting "File" > "Open Folder."

3. Once your files are loaded, right-click on the HTML file you want to run and select "Open with Live Server" or "Open in Browser" to launch it in your default web browser.

4. Optionally you can have the Live Server extension installed for real-time updates. This allows you to see changes immediately as we edit our project.
