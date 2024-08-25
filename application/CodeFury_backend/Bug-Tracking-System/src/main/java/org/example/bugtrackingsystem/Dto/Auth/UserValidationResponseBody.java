package org.example.bugtrackingsystem.Dto.Auth;

public class UserValidationResponseBody {
    private String name;
    private String role;
    private String emailId;
    private String userLogDate;

    public UserValidationResponseBody(String name, String role, String emailId, String userLogDate) {
        this.name = name;
        this.role = role;
        this.emailId = emailId;
        this.userLogDate = userLogDate;
    }

    public UserValidationResponseBody() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserLogDate() {
        return userLogDate;
    }

    public void setUserLogDate(String userLogDate) {
        this.userLogDate = userLogDate;
    }
}
