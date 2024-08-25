package org.example.bugtrackingsystem.Dto.DeveloperPage;

public class CloseBugDevRequestDto {

    private String projectId;
    private String bugId;

    public CloseBugDevRequestDto() {
    }

    public CloseBugDevRequestDto(String projectId, String bugId) {
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
