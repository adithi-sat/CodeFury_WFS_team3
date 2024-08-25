
var i = 0; // Initialize 'i' as a global variable  
      window.onload = function() {
          i = 0; // Reset 'i' when the function starts
          typeWriter(); // Call the typewriter function
      };  
      function typeWriter() {
          var text = "Welcome to AKIRA - the awesome bug tracking app.";
          var speed = 50;          
          if (i < text.length) {
              document.getElementById("productTagLine").innerHTML += text.charAt(i);
              i++;
              setTimeout(typeWriter, speed);
          }
      }
document.getElementById("loginForm").addEventListener("submit", function(event){
        event.preventDefault();
        var userid=document.getElementById("userId").value.trim();
        var pwd=document.getElementById("password").value.trim();

        document.getElementById("userIdError").textContent="";
        document.getElementById("passwordError").textContent="";
        let validLogin=true;
        if(userid === "" || userid === null){
            document.getElementById("userIdError").textContent="User ID can't be empty";
            validLogin=false;
        }
        if(pwd === "" || pwd === null){
            document.getElementById("passwordError").textContent="Please enter password";
            validLogin=false;
        }
        // plus verification using backend data apart from client side validation

        if(validLogin){
            alert("Logged in successfully!");
            sessionStorage.setItem("user",userid);
            window.location.href='ProjManager.html';
        }
});