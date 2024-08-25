package org.example.bugtrackingsystem.service.ProjectAndBugDetailService;

import org.example.bugtrackingsystem.Dto.ProjectAndBugDetailsDto.ProjectBugRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectAndBugDetailsDto.ProjectBugResponseDto;
import org.example.bugtrackingsystem.Utils.Exceptions.ProjectNotFoundException;
import org.example.bugtrackingsystem.Utils.Exceptions.UserNotfoundException;
import org.example.bugtrackingsystem.dao.AuthDao.UserDao;
import org.example.bugtrackingsystem.dao.AuthDao.UserFactory;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDao;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDaoImplFactory;
import org.example.bugtrackingsystem.models.Auth.Users;
import org.example.bugtrackingsystem.models.Bug.BugDetail;
import org.example.bugtrackingsystem.models.ProjectDetails.Project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectBugDetailsService {

    private ProjectDao projectDao;
    private UserDao userDao;
    private BugDao bugDao;

    public ProjectBugDetailsService(){
        projectDao = ProjectDaoImplFactory.getProjectDaoImpl("jdbc");
        userDao = UserFactory.getUserDaoImpl("jdbc");
        bugDao = BugImplDaoFactory.getBugDaoImpl("jdbc");
    }

    public ProjectBugResponseDto getProjectBugDetails(ProjectBugRequestDto requestDto) {
        ProjectBugResponseDto responseDto = new ProjectBugResponseDto();
        List<BugDetail> bugDetails = new ArrayList<>();

        try {
            String role = requestDto.getRole();
            String projId = requestDto.getProjId();
            String userId = requestDto.getUserId();

            Project project = projectDao.getByProjectId(projId);
            responseDto.setProjId(project.getProjId());
            responseDto.setProjName(project.getProjName());
            responseDto.setProjDesc(project.getProjDesc());
            responseDto.setProjStartDate(project.getProjStartDate());
            responseDto.setProjEndDate(project.getProjEndDate());
            responseDto.setProjStatus(project.getProjStatus());
            responseDto.setProjPmId(project.getProjPmId());

            Users projectManager = userDao.getByUserId(project.getProjPmId());
            responseDto.setProjPmName(projectManager.getName());

            if ("project manager".equalsIgnoreCase(role)) {
                bugDetails = bugDao.getBugByProjectId(projId);
            } else if ("developer".equalsIgnoreCase(role)) {
                bugDetails = bugDao.getBugByDevAssignedId(userId,projId);
            } else if ("tester".equalsIgnoreCase(role)) {
                bugDetails = bugDao.getBugByCreatedBy(userId,projId);
            } else {
                throw new IllegalArgumentException("Invalid role provided: " + role);
            }

            responseDto.setBugDetails(bugDetails);
            responseDto.setStatus(200);

        } catch (IllegalArgumentException | ProjectNotFoundException | UserNotfoundException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            responseDto.setStatus(-1);
        }

        return responseDto;
    }

}
