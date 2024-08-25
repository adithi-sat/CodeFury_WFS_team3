package org.example.bugtrackingsystem.dao.AuthDao;

import org.example.bugtrackingsystem.Utils.Exceptions.UserIdAlreadyExistsException;
import org.example.bugtrackingsystem.Utils.Exceptions.UserLogNotFoundException;
import org.example.bugtrackingsystem.Utils.Exceptions.UserNotfoundException;
import org.example.bugtrackingsystem.models.Auth.UserLog;
import org.example.bugtrackingsystem.models.Auth.Users;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public void add(Users e) throws UserIdAlreadyExistsException, SQLException,ClassNotFoundException;
    public Users getByUserId(String id) throws UserNotfoundException, ClassNotFoundException, SQLException;
    public UserLog getUserLogById(String id) throws UserLogNotFoundException, ClassNotFoundException, SQLException;
    public void addUserLog(String id) throws ClassNotFoundException,SQLException;
    public List<String> getFreeDeveloperIds();
    public List<String> getFreeTesterIds();
}
