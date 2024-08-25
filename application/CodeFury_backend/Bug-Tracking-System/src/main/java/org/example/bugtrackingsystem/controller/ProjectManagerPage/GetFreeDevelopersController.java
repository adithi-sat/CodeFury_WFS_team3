package org.example.bugtrackingsystem.controller.ProjectManagerPage;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmResponseDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.ListOfFreeMembers.FreeMembersResponseDto;
import org.example.bugtrackingsystem.service.ProjectMangerPage.ListOfFreeMembersService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api-get-free-developers")
public class GetFreeDevelopersController extends HttpServlet {

    ListOfFreeMembersService listOfFreeMembersService = new ListOfFreeMembersService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        FreeMembersResponseDto freeMembersResponseDto = listOfFreeMembersService.getFreeDevs();

        ObjectMapper mapObjectToJson = new ObjectMapper();

        String jsonRes = mapObjectToJson.writeValueAsString(freeMembersResponseDto);

        System.out.println(jsonRes);


        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonRes);
        out.flush();

    }

}
