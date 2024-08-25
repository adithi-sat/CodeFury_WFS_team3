package org.example.bugtrackingsystem.models.ProjectDetails;

public class ResponseProjectDto {

    private String projectId;
    private String projectName;
    private String projectStatus;

    public ResponseProjectDto() {
    }

    public ResponseProjectDto(String projectId, String projectName, String projectStatus) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }
}
