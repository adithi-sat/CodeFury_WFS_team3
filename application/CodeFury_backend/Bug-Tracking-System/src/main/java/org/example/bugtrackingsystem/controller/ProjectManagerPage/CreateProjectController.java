package org.example.bugtrackingsystem.controller.ProjectManagerPage;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject.CreateProjectRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject.CreateProjectResponseDto;
import org.example.bugtrackingsystem.service.ProjectMangerPage.CreateProjectService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/create-project")
public class CreateProjectController extends HttpServlet {

    CreateProjectService createProjectService = new CreateProjectService();

    @Override
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

        CreateProjectRequestDto cpDto = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            cpDto = mapper.readValue(json, CreateProjectRequestDto.class);
        }catch (Exception e){
            System.out.println("error is "+e.getMessage());
        }

        System.out.println(cpDto);

        CreateProjectResponseDto createProjectResponseDto = createProjectService.addProject(cpDto);

        ObjectMapper mapObjectToJson = new ObjectMapper();

        String jsonRes = mapObjectToJson.writeValueAsString(createProjectResponseDto);

        System.out.println(jsonRes);


        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonRes);
        out.flush();

    }

}
