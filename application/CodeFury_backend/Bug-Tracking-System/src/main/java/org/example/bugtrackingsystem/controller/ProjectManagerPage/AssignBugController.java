package org.example.bugtrackingsystem.controller.ProjectManagerPage;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug.AssignBugRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug.AssignBugResponseDto;
import org.example.bugtrackingsystem.Dto.TesterPage.ReportingBug.ReportBugRequestDto;
import org.example.bugtrackingsystem.Dto.TesterPage.ReportingBug.ReportBugResponseDto;
import org.example.bugtrackingsystem.service.ProjectMangerPage.AssignBugService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


@WebServlet("/api-assign-bug")
public class AssignBugController extends HttpServlet {

    AssignBugService assignBugService = new AssignBugService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(request.getInputStream()));

        String json = "";
        if(br != null){
            try {
                json = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(json);
        }

        AssignBugRequestDto abDto = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            abDto = mapper.readValue(json,AssignBugRequestDto.class);
        }catch (Exception e){
            System.out.println("error is "+e.getMessage());
        }

        System.out.println(abDto);

        AssignBugResponseDto assignBugResponseDto = assignBugService.assignBug(abDto);

        ObjectMapper mapObjectToJson = new ObjectMapper();

        String jsonRes = mapObjectToJson.writeValueAsString(assignBugResponseDto);

        System.out.println(jsonRes);


        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonRes);
        out.flush();

    }

}
