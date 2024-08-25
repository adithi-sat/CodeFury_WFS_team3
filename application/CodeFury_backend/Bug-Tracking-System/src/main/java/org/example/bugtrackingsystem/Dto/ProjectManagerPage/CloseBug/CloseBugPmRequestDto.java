package org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug;

public class CloseBugPmRequestDto {
    private String projectId;
    private String bugId;

    public CloseBugPmRequestDto() {
    }

    public CloseBugPmRequestDto(String projectId, String bugId) {
        this.projectId = projectId;
        this.bugId = bugId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }
}
