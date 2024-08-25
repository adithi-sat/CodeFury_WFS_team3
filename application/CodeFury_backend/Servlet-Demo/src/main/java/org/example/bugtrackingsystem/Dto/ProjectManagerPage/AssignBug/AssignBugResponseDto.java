package org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug;

public class AssignBugResponseDto {

    private int status;
    private String desc;

    public AssignBugResponseDto() {
    }

    public AssignBugResponseDto(int status, String desc) {
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
        return "AssignBugResponseDto{" +
                "status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }
}
