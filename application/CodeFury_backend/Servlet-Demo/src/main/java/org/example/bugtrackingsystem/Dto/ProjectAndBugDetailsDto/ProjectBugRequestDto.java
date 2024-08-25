package org.example.bugtrackingsystem.Dto.ProjectAndBugDetailsDto;

public class ProjectBugRequestDto {
    private String userId;
    private String role;
    private String projId;

    // Default constructor
    public ProjectBugRequestDto() {
    }

    // Parameterized constructor
    public ProjectBugRequestDto(String userId, String role, String projId) {
        this.userId = userId;
        this.role = role;
        this.projId = projId;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }
}

