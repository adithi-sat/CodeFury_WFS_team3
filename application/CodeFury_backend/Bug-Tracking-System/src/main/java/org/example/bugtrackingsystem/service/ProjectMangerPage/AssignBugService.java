package org.example.bugtrackingsystem.service.ProjectMangerPage;

import org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug.AssignBugRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug.AssignBugResponseDto;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;

public class AssignBugService {

    private BugDao bugDao;

    public AssignBugService(){
        bugDao = BugImplDaoFactory.getBugDaoImpl("jdbc");
    }

    public AssignBugResponseDto assignBug(AssignBugRequestDto abDto){
        try{
            String bugId = bugDao.assignBug(abDto.getDevId(),abDto.getProjectId(),abDto.getBugId());
            return new AssignBugResponseDto(200,bugId+" is assigned to a dev");
        } catch (RuntimeException ex){
            return new AssignBugResponseDto(-1,"oops something went wrong");
        }
    }

}
