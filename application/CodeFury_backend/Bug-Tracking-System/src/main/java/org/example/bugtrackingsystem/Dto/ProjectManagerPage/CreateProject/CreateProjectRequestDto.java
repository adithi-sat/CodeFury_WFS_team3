package org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject;

import java.util.List;

public class CreateProjectRequestDto {

    private String projId;
    private String projName;
    private String projDesc;
    private String projStartDate;
    private String projEndDate;
    private String projStatus;
    private String projPmId;
    private List<Team> projectTeam;

    public CreateProjectRequestDto() {
    }

    public CreateProjectRequestDto(String projId, String projName, String projDesc, String projStartDate,
                                   String projEndDate, String projStatus, String projPmId, List<Team> projectTeam) {
        this.projId = projId;
        this.projName = projName;
        this.projDesc = projDesc;
        this.projStartDate = projStartDate;
        this.projEndDate = projEndDate;
        this.projStatus = projStatus;
        this.projPmId = projPmId;
        this.projectTeam = projectTeam;
    }

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

    public List<Team> getProjectTeam() {
        return projectTeam;
    }

    public void setProjectTeam(List<Team> projectTeam) {
        this.projectTeam = projectTeam;
    }

    @Override
    public String toString() {
        return "CreateProjectRequestDto{" +
                "projId='" + projId + '\'' +
                ", projName='" + projName + '\'' +
                ", projDesc='" + projDesc + '\'' +
                ", projStartDate='" + projStartDate + '\'' +
                ", projEndDate='" + projEndDate + '\'' +
                ", projStatus='" + projStatus + '\'' +
                ", projPmId='" + projPmId + '\'' +
                ", projectTeam=" + projectTeam +
                '}';
    }
}
