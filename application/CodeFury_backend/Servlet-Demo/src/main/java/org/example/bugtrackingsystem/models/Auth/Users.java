package org.example.bugtrackingsystem.models.Auth;

public class Users {
    private String name;
    private String mobile;
    private String emailId;
    private String userId;
    private String pwd;
    private String role;

    public Users(String name, String mobile, String emailId, String userId, String pwd, String role) {
        this.name = name;
        this.mobile = mobile;
        this.emailId = emailId;
        this.userId = userId;
        this.pwd = pwd;
        this.role = role;
    }

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", emailId='" + emailId + '\'' +
                ", userId='" + userId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
