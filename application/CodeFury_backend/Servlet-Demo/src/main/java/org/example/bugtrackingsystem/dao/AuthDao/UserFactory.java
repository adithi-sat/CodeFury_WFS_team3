package org.example.bugtrackingsystem.dao.AuthDao;

public class UserFactory {
    public static UserDao getUserDaoImpl(String type){
        if(type.equalsIgnoreCase("jdbc")){
            return new UserImplDao();
        }
        throw new RuntimeException();
    }
}
