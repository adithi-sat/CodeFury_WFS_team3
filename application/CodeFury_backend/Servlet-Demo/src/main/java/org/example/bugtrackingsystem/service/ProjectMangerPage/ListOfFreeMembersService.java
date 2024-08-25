package org.example.bugtrackingsystem.service.ProjectMangerPage;

import org.example.bugtrackingsystem.Dto.ProjectManagerPage.ListOfFreeMembers.FreeMembersResponseDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.ListOfFreeMembers.Members;
import org.example.bugtrackingsystem.dao.AuthDao.UserDao;
import org.example.bugtrackingsystem.dao.AuthDao.UserFactory;

import java.util.ArrayList;
import java.util.List;

public class ListOfFreeMembersService {

    private UserDao userDao;

    public ListOfFreeMembersService(){
        userDao = UserFactory.getUserDaoImpl("jdbc");
    }

    public FreeMembersResponseDto getFreeDevs(){

        try {
            List<String> list = userDao.getFreeDeveloperIds();
            List<Members> finalList = new ArrayList<>();
            for(String it:list){
                finalList.add(new Members(it));
            }
            return new FreeMembersResponseDto(finalList,200);
        }catch (RuntimeException ex){
            return new FreeMembersResponseDto(null,-1);
        }

    }

    public FreeMembersResponseDto getFreeTesters(){

        try {
            List<String> list = userDao.getFreeTesterIds();
            List<Members> finalList = new ArrayList<>();
            for(String it:list){
                finalList.add(new Members(it));
            }
            return new FreeMembersResponseDto(finalList,200);
        }catch (RuntimeException ex){
            return new FreeMembersResponseDto(null,-1);
        }

    }

}
