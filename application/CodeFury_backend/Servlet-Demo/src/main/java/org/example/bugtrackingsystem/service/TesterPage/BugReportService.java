package org.example.bugtrackingsystem.service.TesterPage;

import org.example.bugtrackingsystem.Dto.TesterPage.ReportingBug.ReportBugRequestDto;
import org.example.bugtrackingsystem.Dto.TesterPage.ReportingBug.ReportBugResponseDto;
import org.example.bugtrackingsystem.Utils.Exceptions.ProjectMarkedDoneException;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;
import org.example.bugtrackingsystem.models.Bug.Bug;

public class BugReportService {

    private BugDao bugDao;

    public BugReportService(){
        bugDao = BugImplDaoFactory.getBugDaoImpl("jdbc");
    }

    public ReportBugResponseDto reportingBug(ReportBugRequestDto rbrDto){
        try {
            String bugId = bugDao.reportBug(new Bug(rbrDto.getCreatedBy(),rbrDto.getCreatedOn(),rbrDto.getBugDesc(),
                    rbrDto.getSeverity(),rbrDto.getProjId(),rbrDto.getDevId()));
            return new ReportBugResponseDto(200,bugId);
        } catch (ProjectMarkedDoneException e) {
            return new ReportBugResponseDto(-1,null);
        }
    }

}
