package org.example.bugtrackingsystem.Dto.TesterPage.ReportingBug;

public class ReportBugResponseDto {
    private int status;
    private String bugId;

    public ReportBugResponseDto() {
    }

    public ReportBugResponseDto(int status,String bugId) {
        this.status = status;
        this.bugId = bugId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    @Override
    public String toString() {
        return "ReportBugResponseDto{" +
                "status=" + status +
                ", bugId='" + bugId + '\'' +
                '}';
    }
}
