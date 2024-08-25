package org.example.bugtrackingsystem.Dto.TesterPage.ReportingBug;

public class ReportBugRequestDto {
    private String createdBy;
    private String createdOn;
    private String bugDesc;
    private String severity;
    private String projId;
    private String devId;


    public ReportBugRequestDto(String createdBy, String createdOn, String bugDesc, String severity, String projId,
                               String devId) {
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.bugDesc = bugDesc;
        this.severity = severity;
        this.projId = projId;
        this.devId = devId;

    }

    public ReportBugRequestDto() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getBugDesc() {
        return bugDesc;
    }

    public void setBugDesc(String bugDesc) {
        this.bugDesc = bugDesc;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

}
