package org.example.bugtrackingsystem.Dto.Auth;

public class UserRegisterResponseDto {
    private int status;
    private String name;

    public UserRegisterResponseDto(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public UserRegisterResponseDto() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
