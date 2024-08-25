package org.example.bugtrackingsystem.controller.ProjectAndBugDetailsController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bugtrackingsystem.Dto.ProjectAndBugDetailsDto.ProjectBugRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectAndBugDetailsDto.ProjectBugResponseDto;
import org.example.bugtrackingsystem.service.ProjectAndBugDetailService.ProjectBugDetailsService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/api-get-project-detail")
public class ProjectBugDetailController extends HttpServlet {

    ProjectBugDetailsService projectBugDetailsService = new ProjectBugDetailsService();

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

        ProjectBugRequestDto pbDto = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            pbDto = mapper.readValue(json, ProjectBugRequestDto.class);
        }catch (Exception e){
            System.out.println("error is "+e.getMessage());
        }

        System.out.println(pbDto);

        ProjectBugResponseDto projectBugResponseDto = projectBugDetailsService.getProjectBugDetails(pbDto);

        ObjectMapper mapObjectToJson = new ObjectMapper();

        String jsonRes = mapObjectToJson.writeValueAsString(projectBugResponseDto);

        System.out.println(jsonRes);


        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonRes);
        out.flush();

    }

}
