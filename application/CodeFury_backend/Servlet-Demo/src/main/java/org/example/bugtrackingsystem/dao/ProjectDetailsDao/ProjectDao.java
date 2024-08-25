package org.example.bugtrackingsystem.dao.ProjectDetailsDao;

import org.example.bugtrackingsystem.Utils.Exceptions.ProjectNotFoundException;
import org.example.bugtrackingsystem.models.ProjectDetails.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectDao {
    public Project getByProjectId(String id) throws ProjectNotFoundException;
    public String addProject(Project p);
    public String addProjectTeam(String userId,String role,String projId);
    public Optional<Project> getProjectByProjectMangerId(String id);
    public List<Optional<Project>> getProjectByUserIdAndRole(String userId, String role);
    public String updateProjectStatusByProjectId(String projId);
}
