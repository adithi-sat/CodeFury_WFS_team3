package org.example.bugtrackingsystem.dao.BugsDao;

public class BugImplDaoFactory {
    public static BugDao getBugDaoImpl(String type){
        if(type.equalsIgnoreCase("jdbc")){
            return new BugImplDao();
        }else {
            throw new RuntimeException();
        }
    }
}
