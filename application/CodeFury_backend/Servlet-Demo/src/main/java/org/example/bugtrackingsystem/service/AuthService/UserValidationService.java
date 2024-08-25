package org.example.bugtrackingsystem.service.AuthService;

import org.example.bugtrackingsystem.Dto.Auth.UserValidationRequestDto;
import org.example.bugtrackingsystem.Dto.Auth.UserValidationResponseBody;
import org.example.bugtrackingsystem.Dto.Auth.UserValidationResponseDto;
import org.example.bugtrackingsystem.Utils.Exceptions.UserLogNotFoundException;
import org.example.bugtrackingsystem.Utils.Exceptions.UserNotfoundException;
import org.example.bugtrackingsystem.dao.AuthDao.UserDao;
import org.example.bugtrackingsystem.dao.AuthDao.UserFactory;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDao;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectImplDao;
import org.example.bugtrackingsystem.models.Auth.*;
import org.example.bugtrackingsystem.models.ProjectDetails.Project;
import org.example.bugtrackingsystem.models.ProjectDetails.ResponseProjectDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserValidationService {
    private UserDao userDao;
    private ProjectDao projectDao;

    public UserValidationService(){

        userDao = UserFactory.getUserDaoImpl("jdbc");
        projectDao = new ProjectImplDao();
    }

    public UserValidationResponseDto validateUser(UserValidationRequestDto uvr){

        String id = uvr.getUserId();
        String pwd = uvr.getPwd();
        try{
            Users u = userDao.getByUserId(id);
            if(u.getPwd().equals(pwd)) {
                try {
                    UserLog ul = userDao.getUserLogById(id);
                    System.out.println("Success and user has log history");
                    userDao.addUserLog(id);

                    List<Optional<Project>> listOfProject = projectDao.getProjectByUserIdAndRole(u.getUserId(),u.getRole());

                    if(listOfProject.isEmpty()){
                        return new UserValidationResponseDto(200,new UserValidationResponseBody(u.getName(),u.getRole(),u.getEmailId(),
                                ul.getLogDate()),null);
                    }else{
                        List<ResponseProjectDto> responseProjectDtoList = createResponseProjectDtoList(listOfProject);
                        return new UserValidationResponseDto(200,new UserValidationResponseBody(u.getName(),u.getRole(),u.getEmailId(),
                                ul.getLogDate()),responseProjectDtoList);
                    }
                } catch (UserLogNotFoundException ex) {
                    System.out.println("User has no log history (first time log in)");
                    userDao.addUserLog(id);

                    List<Optional<Project>> listOfProject = projectDao.getProjectByUserIdAndRole(u.getUserId(),u.getRole());

                    if(listOfProject.isEmpty()){
                        return new UserValidationResponseDto(200,new UserValidationResponseBody(u.getName(),u.getRole(),u.getEmailId(),
                                ""),null);
                    }else{
                        List<ResponseProjectDto> responseProjectDtoList = createResponseProjectDtoList(listOfProject);
                        return new UserValidationResponseDto(200,new UserValidationResponseBody(u.getName(),u.getRole(),u.getEmailId(),
                                ""),responseProjectDtoList);
                    }
                }
            }else{
                System.out.println("user id or password incorrect");
                return new UserValidationResponseDto(0,null,null);
            }
        }catch (UserNotfoundException ex){
            System.out.println("User not found");
            return new UserValidationResponseDto(1,null,null);
        }catch (ClassNotFoundException ex){
            System.out.println("JDBC driver failed to connect");
            return new UserValidationResponseDto(2,null,null);
        }catch (SQLException ex){
            System.out.println("Some error occured while connection or in sql execution");
            return new UserValidationResponseDto(3,null,null);
        }
    }

    private List<ResponseProjectDto> createResponseProjectDtoList(List<Optional<Project>> listOfProject) {
        if(listOfProject.isEmpty()){
            return new ArrayList<>();
        }else{
            List<ResponseProjectDto> list = new ArrayList<>();
            for(Optional<Project> op:listOfProject){
                if(op.isPresent()){
                    list.add(new ResponseProjectDto(op.get().getProjId(),op.get().getProjName(),op.get().getProjStatus()));
                }
            }
            return list;
        }
    }

}
