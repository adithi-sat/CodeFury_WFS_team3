package org.example.bugtrackingsystem.service.DeveloperPage;

import org.example.bugtrackingsystem.Dto.DeveloperPage.CloseBugDevRequestDto;
import org.example.bugtrackingsystem.Dto.DeveloperPage.CloseBugDevResponseDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug.AssignBugResponseDto;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;

public class CloseBugDeveloperService {

    private BugDao bugDao;

    public CloseBugDeveloperService(){
        bugDao = BugImplDaoFactory.getBugDaoImpl("jdbc");
    }

    public CloseBugDevResponseDto closeBugDev(CloseBugDevRequestDto cbdDto){

        try{
            String bugId = bugDao.updateCloseDateDev(cbdDto.getProjectId(),cbdDto.getBugId());
            return new CloseBugDevResponseDto(200,bugId+" is closed by dev");
        } catch (RuntimeException ex){
            return new CloseBugDevResponseDto(-1,"oops something went wrong");
        }

    }

}
