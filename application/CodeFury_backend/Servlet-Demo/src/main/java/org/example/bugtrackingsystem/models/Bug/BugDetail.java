package org.example.bugtrackingsystem.models.Bug;

public class BugDetail {

    private String bugId;
    private String createdBy;
    private String createdOn;
    private String bugDesc;
    private String severity;
    private String projId;
    private String devId;
    private String closeDateDev;
    private String closeDatePm;
    private String createdByName;

    public BugDetail(String bugId, String createdBy, String createdOn, String bugDesc, String severity,
                     String projId, String devId, String closeDateDev, String closeDatePm, String createdByName) {
        this.bugId = bugId;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.bugDesc = bugDesc;
        this.severity = severity;
        this.projId = projId;
        this.devId = devId;
        this.closeDateDev = closeDateDev;
        this.closeDatePm = closeDatePm;
        this.createdByName = createdByName;
    }

    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
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

    public String getCloseDateDev() {
        return closeDateDev;
    }

    public void setCloseDateDev(String closeDateDev) {
        this.closeDateDev = closeDateDev;
    }

    public String getCloseDatePm() {
        return closeDatePm;
    }

    public void setCloseDatePm(String closeDatePm) {
        this.closeDatePm = closeDatePm;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }
}
