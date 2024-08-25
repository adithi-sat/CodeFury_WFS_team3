package org.example.bugtrackingsystem.dao.ProjectDetailsDao;

public class ProjectDaoImplFactory {
    public static ProjectDao getProjectDaoImpl(String type){
        if(type.equalsIgnoreCase("jdbc")){
            return new ProjectImplDao();
        }else {
            throw new RuntimeException();
        }
    }
}
