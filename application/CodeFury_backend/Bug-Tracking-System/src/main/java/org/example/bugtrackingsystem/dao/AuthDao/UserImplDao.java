package org.example.bugtrackingsystem.dao.AuthDao;

import org.example.bugtrackingsystem.Utils.Exceptions.UserIdAlreadyExistsException;
import org.example.bugtrackingsystem.Utils.Exceptions.UserLogNotFoundException;
import org.example.bugtrackingsystem.Utils.Exceptions.UserNotfoundException;
import org.example.bugtrackingsystem.dao.AuthDao.UserDao;
import org.example.bugtrackingsystem.models.Auth.UserLog;
import org.example.bugtrackingsystem.models.Auth.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImplDao implements UserDao {
    @Override
    public void add(Users e) throws UserIdAlreadyExistsException,SQLException,ClassNotFoundException{
        Connection conn = null;
        try {
            conn = getConnection();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
            throw ex;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            throw ex;
        }

        try {
            String findQuery = "select count(userId) from users where userid = ?";
            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            pstmt.setString(1,e.getUserId());

            ResultSet rs = pstmt.executeQuery();

            if(rs.next() && rs.getInt("count(userId)")!=0){
                throw new UserIdAlreadyExistsException();
            }else{
                String insertQuery = "insert into users(userid,name,mobile,emailid,role,pwd) values(?,?,?,?,?,?)";
                PreparedStatement pstmt2 = conn.prepareStatement(insertQuery);
                pstmt2.setString(1,e.getUserId());
                pstmt2.setString(2,e.getName());
                pstmt2.setString(3,e.getMobile());
                pstmt2.setString(4,e.getEmailId());
                pstmt2.setString(5, e.getRole());
                pstmt2.setString(6, e.getPwd());

                int count = pstmt2.executeUpdate();

                System.out.println(count+" rows affected....");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            throw ex;
        }finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    @Override
    public Users getByUserId(String id) throws UserNotfoundException, ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
            throw ex;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            throw ex;
        }

        try{
            String query = "select * from users where userid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,id);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                String userId = rs.getString("userid");
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                String emailId= rs.getString("emailid");
                String role = rs.getString("role");
                String pwd = rs.getString("pwd");
                return new Users(name,mobile,emailId,userId,pwd,role);
            }else{
                throw new UserNotfoundException();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
            throw ex;
        }

    }

    @Override
    public UserLog getUserLogById(String id) throws UserLogNotFoundException, ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
            throw ex;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            throw ex;
        }

        try{
            String query = "select Date_format(max(logdate),'%d-%m-%y %T') as logdate from userlog where userid = ? group by userid";
            PreparedStatement pstmt = conn.prepareStatement(query);
            System.out.println(id);
            pstmt.setString(1,id);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                String userLogDateTime = rs.getString("logdate");
                return new UserLog(id,userLogDateTime);
            }else{
                throw new UserLogNotFoundException();
            }

        }catch (SQLException ex){
            ex.printStackTrace();
            throw ex;
        }

    }

    @Override
    public void addUserLog(String id) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            conn = getConnection();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
            throw ex;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            throw ex;
        }

        try {
            String insertQuery = "insert into userlog(userid,logdate) values(?,now())";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1,id);

            int count = pstmt.executeUpdate();

            System.out.println(count+" rows affected....");
        }catch (SQLException ex){
            ex.printStackTrace();
            throw ex;
        }finally {
            conn.close();
        }

    }

    @Override
    public List<String> getFreeDeveloperIds() {

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

        String findQuery = "select userid from users where role = 'developer' and userid not in " +
                "(select u.userid from proj_team_details u left join project_master p on u.projid = p.projid where role = 'developer'" +
                " and projstatus = 'In Progres)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            ResultSet rs = pstmt.executeQuery();
            List<String> list = new ArrayList<>();
            while(rs.next()){
                String uId = rs.getString("userid");
                list.add(uId);
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<String> getFreeTesterIds() {
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

        String findQuery = "select userid from users where role = 'tester' and userid not in " +
                "(select u.userid from proj_team_details u left join project_master p on u.projid = p.projid where u.role = 'tester'" +
                " and p.projstatus = 'In Progress' group by userid having count(*) >= 2)";

        try {

            PreparedStatement pstmt = conn.prepareStatement(findQuery);
            ResultSet rs = pstmt.executeQuery();
            List<String> list = new ArrayList<>();
            while(rs.next()){
                String uId = rs.getString("userid");
                list.add(uId);
            }

            return list;

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
