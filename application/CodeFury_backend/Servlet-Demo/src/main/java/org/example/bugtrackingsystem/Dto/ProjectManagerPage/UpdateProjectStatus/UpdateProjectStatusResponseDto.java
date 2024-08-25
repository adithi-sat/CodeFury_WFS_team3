package org.example.bugtrackingsystem.Dto.ProjectManagerPage.UpdateProjectStatus;

public class UpdateProjectStatusResponseDto {
    private int status;
    private String desc;

    public UpdateProjectStatusResponseDto() {
    }

    public UpdateProjectStatusResponseDto(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "UpdateProjectStatusResponseDto{" +
                "status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
