package org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug;

public class AssignBugRequestDto {

    private String devId;
    private String projectId;
    private String bugId;

    public AssignBugRequestDto() {
    }

    public AssignBugRequestDto(String devId, String projectId, String bugId) {
        this.devId = devId;
        this.projectId = projectId;
        this.bugId = bugId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
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
