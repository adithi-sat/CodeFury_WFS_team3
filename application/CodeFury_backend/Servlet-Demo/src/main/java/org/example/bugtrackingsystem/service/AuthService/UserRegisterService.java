package org.example.bugtrackingsystem.service.AuthService;

import org.example.bugtrackingsystem.Utils.Exceptions.UserIdAlreadyExistsException;
import org.example.bugtrackingsystem.dao.AuthDao.UserDao;
import org.example.bugtrackingsystem.dao.AuthDao.UserFactory;
import org.example.bugtrackingsystem.models.Auth.Users;

import java.sql.SQLException;

public class UserRegisterService {

    private UserDao userDao;

    public UserRegisterService(){
        userDao = UserFactory.getUserDaoImpl("jdbc");
    }

    public int addUser(Users u){
        int status = -1;
        try {
            userDao.add(u);
            status = 200;
            System.out.println("success");
        } catch (UserIdAlreadyExistsException ex) {
            status = 0;
            System.out.println("Employee already exists");
        }catch (ClassNotFoundException ex){
            status = 1;
            System.out.println("jdbc driver conn failed failed");
        }catch (SQLException ex){
            status = 2;
            System.out.println("Some error occured");
        }
        return status;
    }
}
