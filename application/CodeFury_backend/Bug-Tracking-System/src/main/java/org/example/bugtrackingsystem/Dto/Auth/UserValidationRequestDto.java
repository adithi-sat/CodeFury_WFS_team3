package org.example.bugtrackingsystem.Dto.Auth;

public class UserValidationRequestDto {
    private String userId;
    private String pwd;

    public UserValidationRequestDto() {
    }

    public UserValidationRequestDto(String userId, String pwd) {
        this.userId = userId;
        this.pwd = pwd;
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

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
