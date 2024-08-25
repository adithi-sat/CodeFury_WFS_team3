package org.example.bugtrackingsystem.Dto.ProjectAndBugDetailsDto;

import org.example.bugtrackingsystem.models.Bug.BugDetail;

import java.util.List;

public class ProjectBugResponseDto {
    private String projId;
    private String projName;
    private String projDesc;
    private String projStartDate;
    private String projEndDate;
    private String projStatus;
    private String projPmId;
    private String projPmName; // Added projectPmName
    private List<BugDetail> bugDetails;
    private int status; // Added status field

    // Default constructor
    public ProjectBugResponseDto() {
    }

    // Parameterized constructor
    public ProjectBugResponseDto(String projId, String projName, String projDesc,
                                 String projStartDate, String projEndDate, String projStatus,
                                 String projPmId, String projPmName, List<BugDetail> bugDetails, int status) {
        this.projId = projId;
        this.projName = projName;
        this.projDesc = projDesc;
        this.projStartDate = projStartDate;
        this.projEndDate = projEndDate;
        this.projStatus = projStatus;
        this.projPmId = projPmId;
        this.projPmName = projPmName;
        this.bugDetails = bugDetails;
        this.status = status;
    }

    // Getters and Setters
    public String getProjId() {
        return projId;
    }

    public void setProjId(String projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjDesc() {
        return projDesc;
    }

    public void setProjDesc(String projDesc) {
        this.projDesc = projDesc;
    }

    public String getProjStartDate() {
        return projStartDate;
    }

    public void setProjStartDate(String projStartDate) {
        this.projStartDate = projStartDate;
    }

    public String getProjEndDate() {
        return projEndDate;
    }

    public void setProjEndDate(String projEndDate) {
        this.projEndDate = projEndDate;
    }

    public String getProjStatus() {
        return projStatus;
    }

    public void setProjStatus(String projStatus) {
        this.projStatus = projStatus;
    }

    public String getProjPmId() {
        return projPmId;
    }

    public void setProjPmId(String projPmId) {
        this.projPmId = projPmId;
    }

    public String getProjPmName() {
        return projPmName;
    }

    public void setProjPmName(String projPmName) {
        this.projPmName = projPmName;
    }

    public List<BugDetail> getBugDetails() {
        return bugDetails;
    }

    public void setBugDetails(List<BugDetail> bugDetails) {
        this.bugDetails = bugDetails;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}