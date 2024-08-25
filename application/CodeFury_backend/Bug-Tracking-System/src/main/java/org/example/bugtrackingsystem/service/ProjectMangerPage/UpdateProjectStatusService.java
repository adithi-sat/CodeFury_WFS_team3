package org.example.bugtrackingsystem.service.ProjectMangerPage;

import org.example.bugtrackingsystem.Dto.ProjectManagerPage.UpdateProjectStatus.UpdateProjectStatusRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.UpdateProjectStatus.UpdateProjectStatusResponseDto;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDao;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDaoImplFactory;

public class UpdateProjectStatusService {

    private ProjectDao projectDao;


    public UpdateProjectStatusService(){
        projectDao = ProjectDaoImplFactory.getProjectDaoImpl("jdbc");
    }

    public UpdateProjectStatusResponseDto updateProjectStatus(UpdateProjectStatusRequestDto upDto){

        try {
            String projId = projectDao.updateProjectStatusByProjectId(upDto.getProjectId());
            return new UpdateProjectStatusResponseDto(200,projId+" project updated");
        }catch (RuntimeException e){
            return new UpdateProjectStatusResponseDto(-1,"Oops something went wrong");
        }

    }

}
