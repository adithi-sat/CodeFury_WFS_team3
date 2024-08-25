package org.example.bugtrackingsystem.Dto.ProjectManagerPage.UpdateProjectStatus;

public class UpdateProjectStatusRequestDto {

    private String projectId;

    public UpdateProjectStatusRequestDto() {
    }

    public UpdateProjectStatusRequestDto(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
