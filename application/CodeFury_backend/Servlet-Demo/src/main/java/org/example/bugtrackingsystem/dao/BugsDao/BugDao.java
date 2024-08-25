package org.example.bugtrackingsystem.dao.BugsDao;

import org.example.bugtrackingsystem.Utils.Exceptions.BugNotClosedByDeveloperException;
import org.example.bugtrackingsystem.Utils.Exceptions.ProjectMarkedDoneException;
import org.example.bugtrackingsystem.models.Bug.Bug;
import org.example.bugtrackingsystem.models.Bug.BugDetail;

import java.util.List;

public interface BugDao {
    public String reportBug(Bug b) throws ProjectMarkedDoneException;
    public List<BugDetail> getBugByCreatedBy(String createdBy,String projId);
    public List<BugDetail> getBugByDevAssignedId(String devId,String projId);
    public List<BugDetail> getBugByProjectId(String id);
    public String assignBug(String devId,String projectId,String bugId);
    public String updateCloseDateDev(String projectId,String bugId);
    public String updateCloseDatePm(String projectId,String bugId) throws BugNotClosedByDeveloperException;
}
