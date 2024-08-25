package org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject;

public class CreateProjectResponseDto {

    private int status;
    private String projId;

    public CreateProjectResponseDto() {
    }

    public CreateProjectResponseDto(int status, String projId) {
        this.status = status;
        this.projId = projId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    @Override
    public String toString() {
        return "CreateProjectResponseDto{" +
                "status=" + status +
                ", projId='" + projId + '\'' +
                '}';
    }
}
