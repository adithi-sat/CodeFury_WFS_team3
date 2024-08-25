package org.example.bugtrackingsystem.dao.BugsDao;

import org.example.bugtrackingsystem.Utils.Exceptions.BugNotClosedByDeveloperException;
import org.example.bugtrackingsystem.Utils.Exceptions.ProjectMarkedDoneException;
import org.example.bugtrackingsystem.Utils.Exceptions.ProjectNotFoundException;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDao;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDaoImplFactory;
import org.example.bugtrackingsystem.models.Bug.Bug;
import org.example.bugtrackingsystem.models.Bug.BugDetail;
import org.example.bugtrackingsystem.models.ProjectDetails.Project;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BugImplDao implements BugDao{

    private ProjectDao projectDao;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

    public BugImplDao(){
        projectDao = ProjectDaoImplFactory.getProjectDaoImpl("jdbc");
    }

    @Override
    public String reportBug(Bug b) throws ProjectMarkedDoneException {

        Connection conn = null;
        try {
            conn = getConnection();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
        catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }

        //checking if the associated project exist and marked as "inprogress"
        try{
            Project p = projectDao.getByProjectId(b.getProjId());
            if(p.getProjStatus().equalsIgnoreCase("done")){
                throw new ProjectMarkedDoneException();
            }
        }catch (ProjectNotFoundException ex){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException("Project does not even exists");
        }

        //for creating new unique bugid
        String findQuery = "select max(bugid) from project_bug_master";
        String bugId = "B";
        try {
            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String prevBugId = rs.getString("max(bugid)");
            if(prevBugId==null){
                bugId += "_100";
            }else{
                String separator ="_";
                int sepPos = prevBugId.indexOf(separator);
                String numeralPart = prevBugId.substring(sepPos + separator.length());
                int nextSeq = Integer.parseInt(numeralPart)+1;
                bugId += "_"+Integer.toString(nextSeq);
            }
        }catch (SQLException ex){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException("Some error while creating unique bugId");
        }

        //inserting into the project_bug_master;
        String insertQuery = "insert into project_bug_master(bugid,createdby,createdon,bugdesc,severity,projid) " +
                "values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1,bugId);
            pstmt.setString(2,b.getCreatedBy());
            pstmt.setDate(3,new Date(formatter.parse(b.getCreatedOn()).getTime()));
            pstmt.setString(4,b.getBugDesc());
            pstmt.setString(5,b.getSeverity());
            pstmt.setString(6,b.getProjId());

            int count = pstmt.executeUpdate();

            System.out.println(count+" rows inserted into project_bug_master");

            return bugId;

        } catch (SQLException e) {
            System.out.println("Some sql exception");
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<BugDetail> getBugByCreatedBy(String createdById,String projId) {

        Connection conn = null;
        try {
            conn = getConnection();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }
        catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException();
        }

        String findQuery = "select b.bugid,b.createdby,Date_format(b.createdon,'%d-%m-%y') as createdon,b.bugdesc,b.severity,b.projid,b.devid," +
                "Date_format(b.closedatedev,'%d-%m-%y') as closedatedev,Date_format(b.closedatepm,'%d-%m-%y') " +
                "as closedatepm, u.name from project_bug_master b left join users u on b.createdby = u.userid where b.createdby = ? and b.projid = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            pstmt.setString(1,createdById);
            pstmt.setString(2,projId);

            ResultSet rs = pstmt.executeQuery();
            List<BugDetail> list = new ArrayList<>();

            while(rs.next()){
                String bugId = rs.getString("bugid");
                String createdBy = rs.getString("createdby");
                String createdOn = rs.getString("createdon");
                String bugDesc = rs.getString("bugdesc");
                String severity = rs.getString("severity");
                String devId = rs.getString("devid");
                String closeDateDev = rs.getString("closedatedev");
                String closeDatePm = rs.getString("closedatepm");
                String createdByName = rs.getString("name");

                BugDetail bugDetail = new BugDetail(bugId, createdBy, createdOn, bugDesc, severity, projId,
                        devId, closeDateDev, closeDatePm, createdByName);
                list.add(bugDetail);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<BugDetail> getBugByDevAssignedId(String devId,String projId) {

        Connection conn = null;
        try {
            conn = getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }

        String findQuery = "select b.bugid,b.createdby,Date_format(b.createdon,'%d-%m-%y') as createdon,b.bugdesc,b.severity,b.projid,b.devid," +
                "Date_format(b.closedatedev,'%d-%m-%y') as closedatedev,Date_format(b.closedatepm,'%d-%m-%y') " +
                "as closedatepm, u.name from project_bug_master b left join users u on b.devid = u.userid where b.devid = ? and b.projid = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            pstmt.setString(1, devId);
            pstmt.setString(2, projId);

            ResultSet rs = pstmt.executeQuery();
            List<BugDetail> list = new ArrayList<>();

            while (rs.next()) {
                String bugId = rs.getString("bugid");
                String createdBy = rs.getString("createdby");
                String createdOn = rs.getString("createdon");
                String bugDesc = rs.getString("bugdesc");
                String severity = rs.getString("severity");
                String closeDateDev = rs.getString("closedatedev");
                String closeDatePm = rs.getString("closedatepm");
                String createdByName = rs.getString("name");

                BugDetail bugDetail = new BugDetail(bugId, createdBy, createdOn, bugDesc, severity, projId,
                        devId, closeDateDev, closeDatePm, createdByName);
                list.add(bugDetail);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<BugDetail> getBugByProjectId(String projId) {

        Connection conn = null;
        try {
            conn = getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }

        String findQuery = "select b.bugid,b.createdby,Date_format(b.createdon,'%d-%m-%y') as createdon,b.bugdesc,b.severity,b.projid,b.devid," +
                "Date_format(b.closedatedev,'%d-%m-%y') as closedatedev,Date_format(b.closedatepm,'%d-%m-%y') " +
                "as closedatepm, u.name from project_bug_master b left join users u on b.createdby = u.userid where b.projid = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            pstmt.setString(1, projId);

            ResultSet rs = pstmt.executeQuery();
            List<BugDetail> list = new ArrayList<>();

            while (rs.next()) {
                String bugId = rs.getString("bugid");
                String createdBy = rs.getString("createdby");
                String createdOn = rs.getString("createdon");
                String bugDesc = rs.getString("bugdesc");
                String severity = rs.getString("severity");
                String devId = rs.getString("devid");
                String closeDateDev = rs.getString("closedatedev");
                String closeDatePm = rs.getString("closedatepm");
                String createdByName = rs.getString("name");

                BugDetail bugDetail = new BugDetail(bugId, createdBy, createdOn, bugDesc, severity, projId,
                        devId, closeDateDev, closeDatePm, createdByName);
                list.add(bugDetail);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public String assignBug(String devId, String projectId,String bugId) {

        Connection conn = null;
        try {
            conn = getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }

        String updateQuery = "update project_bug_master set devid = ? where projid = ? and bugid = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1,devId);
            pstmt.setString(2,projectId);
            pstmt.setString(3,bugId);

            int count = pstmt.executeUpdate();

            System.out.println(count+" rows updated against project_bug_master");

            return bugId;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @Override
    public String updateCloseDateDev(String projectId, String bugId) {
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }

        String updateQuery = "update project_bug_master set closedatedev = now() where projid = ? and bugid = ?";

        try{
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1,projectId);
            pstmt.setString(2,bugId);

            int count = pstmt.executeUpdate();

            System.out.println(count+" rows updated against project_bug_master");

            return bugId;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public String updateCloseDatePm(String projectId, String bugId) throws BugNotClosedByDeveloperException {
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }

        //Checking if the bug is closed by developer
        String findQuery = "select Date_format(closedatedev,'%d-%m-%y') as closedatedev from project_bug_master where projid = ? and bugid = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            pstmt.setString(1,projectId);
            pstmt.setString(2,bugId);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next() && rs.getString("closedatedev")==null){
                conn.close();
                throw new BugNotClosedByDeveloperException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //updating closedatepm
        String updateQuery = "update project_bug_master set closedatepm = now() where projid = ? and bugid = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1,projectId);
            pstmt.setString(2,bugId);

            int count = pstmt.executeUpdate();

            System.out.println(count+" rows updated against project_bug_master");

            return bugId;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracksys","root","aman.co.in");

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            throw e;
        }

        return conn;
    }

}
