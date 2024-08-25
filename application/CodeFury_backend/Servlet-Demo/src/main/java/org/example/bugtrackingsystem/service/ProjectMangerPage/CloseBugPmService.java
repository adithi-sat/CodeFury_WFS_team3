package org.example.bugtrackingsystem.service.ProjectMangerPage;

import org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug.AssignBugResponseDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmResponseDto;
import org.example.bugtrackingsystem.Utils.Exceptions.BugNotClosedByDeveloperException;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;

public class CloseBugPmService {

    private BugDao bugDao;

    public CloseBugPmService(){
        bugDao = BugImplDaoFactory.getBugDaoImpl("jdbc");
    }

    public CloseBugPmResponseDto closeBugPm(CloseBugPmRequestDto cbprDto){

        try{
            String bugId = bugDao.updateCloseDatePm(cbprDto.getProjectId(),cbprDto.getBugId());
            return new CloseBugPmResponseDto(200,bugId+" is closed by pm");
        } catch (BugNotClosedByDeveloperException e) {
            return new CloseBugPmResponseDto(0,"Bug not closed by deveoper please contact the respective developer");
        }catch (RuntimeException e){
            return new CloseBugPmResponseDto(1,"Oops something went wrong");
        }

    }

}
