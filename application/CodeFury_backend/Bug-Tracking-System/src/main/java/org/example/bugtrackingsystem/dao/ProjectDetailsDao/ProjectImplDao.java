package org.example.bugtrackingsystem.dao.ProjectDetailsDao;

import org.example.bugtrackingsystem.Utils.Exceptions.ProjectNotFoundException;
import org.example.bugtrackingsystem.models.ProjectDetails.Project;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Date;

public class ProjectImplDao implements ProjectDao{

    SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

    @Override
    public Project getByProjectId(String id) throws ProjectNotFoundException {

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

        String findQuery = "select projid,projname,projdesc,Date_format(projstartdate,'%d-%m-%y %T') as projstartdate,Date_format(projenddate,'%d-%m-%y %T') as projenddate,projstatus,projpmid from project_master where projid = ?";
        try {

            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            pstmt.setString(1,id);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                String projId = rs.getString("projid");
                String projName = rs.getString("projname");
                String projDesc = rs.getString("projdesc");
                String projStartDate = rs.getString("projstartdate");
                String projEndDate = rs.getString("projenddate");
                String projStatus = rs.getString("projstatus");
                String projPmId = rs.getString("projpmid");
                return new Project(projId,projName,projDesc,projStartDate,projEndDate,projStatus,projPmId);
            }else{
                throw new ProjectNotFoundException();
            }


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
    public String addProject(Project p) {

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

        String insertQuery = "insert into project_master values(?,?,?,?,?,?,?)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1,p.getProjId());
            pstmt.setString(2,p.getProjName());
            pstmt.setString(3,p.getProjDesc());
            pstmt.setDate(4,new Date(formatter.parse(p.getProjStartDate()).getTime()));
            pstmt.setDate(5, new Date(formatter.parse(p.getProjEndDate()).getTime()));
            pstmt.setString(6,p.getProjStatus());
            pstmt.setString(7,p.getProjPmId());

            int count = pstmt.executeUpdate();

            System.out.println(count+" rows affected");

            return p.getProjId();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String addProjectTeam(String userId, String role, String projId) {

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

        String insertQuery = "insert into proj_team_details values(?,?,?)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1,userId);
            pstmt.setString(2,role);
            pstmt.setString(3,projId);

            int count = pstmt.executeUpdate();

            System.out.println(count+" rows affected");

            return userId+"_"+role;

        }catch (SQLException e) {
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
    public Optional<Project> getProjectByProjectMangerId(String id) {

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

        String findQuery = "select projid,projname,projdesc,Date_format(projstartdate,'%d-%m-%y %T') as projstartdate,Date_format(projenddate,'%d-%m-%y %T') as projenddate,projstatus,projpmid from project_master where projpmid = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            pstmt.setString(1,id);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                String projId = rs.getString("projid");
                String projName = rs.getString("projname");
                String projDesc = rs.getString("projdesc");
                String projStartDate = rs.getString("projstartdate");
                String projEndDate = rs.getString("projenddate");
                String projStatus = rs.getString("projstatus");
                String projPmId = rs.getString("projpmid");
                return Optional.of(new Project(projId,projName,projDesc,projStartDate,projEndDate,projStatus,projPmId));
            }else{
                return Optional.empty();
            }

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
    public List<Optional<Project>> getProjectByUserIdAndRole(String userId, String role) {

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

        String findQuery = " select p.projid,p.projname,p.projstatus,p.projdesc,Date_format(p.projstartdate,'%d-%m-%y %T') as projstartdate,Date_format(p.projenddate,'%d-%m-%y %T') as projenddate,p.projpmid from proj_team_details pt left join project_master p on pt.projid = p.projid where userid = ? and role = ?";
        try {

            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            pstmt.setString(1,userId);
            pstmt.setString(2,role);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                String projId = rs.getString("projid");
                String projName = rs.getString("projname");
                String projDesc = rs.getString("projdesc");
                String projStartDate = rs.getString("projstartdate");
                String projEndDate = rs.getString("projenddate");
                String projStatus = rs.getString("projstatus");
                String projPmId = rs.getString("projpmid");
                List<Optional<Project>> list = new ArrayList<>();
                list.add(Optional.of(new Project(projId,projName,projDesc,projStartDate,projEndDate,projStatus,projPmId)));
                while (rs.next()){
                    String projIds = rs.getString("projid");
                    String projNameS = rs.getString("projname");
                    String projDescS = rs.getString("projdesc");
                    String projStartDateS = rs.getString("projstartdate");
                    String projEndDateS = rs.getString("projenddate");
                    String projStatusS = rs.getString("projstatus");
                    String projPmIdS = rs.getString("projpmid");
                    list.add(Optional.of(new Project(projIds,projNameS,projDescS,projStartDateS,projEndDateS,projStatusS,projPmIdS)));
                }
                return list;
            }else{
                return new ArrayList<>();
            }

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
    public String updateProjectStatusByProjectId(String projId) {

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

        String updateQuery = "update project_master set projstatus = 'done' where projid = ?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1,projId);

            int count = pstmt.executeUpdate();

            System.out.println(count+" rows updated against project_bug_master");

            return projId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
