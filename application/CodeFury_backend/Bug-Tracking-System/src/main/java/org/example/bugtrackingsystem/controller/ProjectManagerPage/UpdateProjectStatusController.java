package org.example.bugtrackingsystem.controller.ProjectManagerPage;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmResponseDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.UpdateProjectStatus.UpdateProjectStatusRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.UpdateProjectStatus.UpdateProjectStatusResponseDto;
import org.example.bugtrackingsystem.service.ProjectMangerPage.CloseBugPmService;
import org.example.bugtrackingsystem.service.ProjectMangerPage.UpdateProjectStatusService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/api-update-project-status")
public class UpdateProjectStatusController extends HttpServlet{

    UpdateProjectStatusService updateProjectStatusService = new UpdateProjectStatusService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(request.getInputStream()));

        String json = "";
        if (br != null) {
            try {
                json = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(json);
        }

        UpdateProjectStatusRequestDto cbpmDto = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            cbpmDto = mapper.readValue(json, UpdateProjectStatusRequestDto.class);
        } catch (Exception e) {
            System.out.println("error is " + e.getMessage());
        }

        System.out.println(cbpmDto);

        UpdateProjectStatusResponseDto updateProjectStatusResponseDto = updateProjectStatusService.updateProjectStatus(cbpmDto);

        ObjectMapper mapObjectToJson = new ObjectMapper();

        String jsonRes = mapObjectToJson.writeValueAsString(updateProjectStatusResponseDto);

        System.out.println(jsonRes);


        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonRes);
        out.flush();
    }
}
