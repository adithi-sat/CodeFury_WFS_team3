package org.example.bugtrackingsystem.Dto.ProjectManagerPage.ListOfFreeMembers;

public class Members {

    private String userId;

    public Members() {
    }

    public Members(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
