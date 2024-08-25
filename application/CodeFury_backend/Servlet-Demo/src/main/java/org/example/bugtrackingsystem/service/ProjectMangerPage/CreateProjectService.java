package org.example.bugtrackingsystem.service.ProjectMangerPage;

import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDao;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDaoImplFactory;
import org.example.bugtrackingsystem.models.ProjectDetails.Project;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject.CreateProjectRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject.CreateProjectResponseDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject.Team;

import java.util.List;

public class CreateProjectService {

    private ProjectDao projectDao;

    public CreateProjectService(){
        projectDao = ProjectDaoImplFactory.getProjectDaoImpl("jdbc");
    }

    public CreateProjectResponseDto addProject(CreateProjectRequestDto cprDto){
        String projId1 = projectDao.addProject(new Project(cprDto.getProjId(),cprDto.getProjName(),cprDto.getProjDesc(),
                cprDto.getProjStartDate(),cprDto.getProjEndDate(),cprDto.getProjStatus(),cprDto.getProjPmId()));
        List<Team> teamMembers = cprDto.getProjectTeam();
        for(Team t:teamMembers){
            String userIdAndRole = projectDao.addProjectTeam(t.getUserId(),t.getRole(),cprDto.getProjId());
        }
        return new CreateProjectResponseDto(200,cprDto.getProjId());
    }

}
