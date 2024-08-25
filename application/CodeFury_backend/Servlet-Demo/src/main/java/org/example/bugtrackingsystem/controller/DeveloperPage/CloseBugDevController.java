package org.example.bugtrackingsystem.controller.DeveloperPage;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bugtrackingsystem.Dto.DeveloperPage.CloseBugDevRequestDto;
import org.example.bugtrackingsystem.Dto.DeveloperPage.CloseBugDevResponseDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmResponseDto;
import org.example.bugtrackingsystem.service.DeveloperPage.CloseBugDeveloperService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/api-close-bug-dev")
public class CloseBugDevController extends HttpServlet {

    CloseBugDeveloperService closeBugDeveloperService = new CloseBugDeveloperService();

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

        CloseBugDevRequestDto cbdDto = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            cbdDto = mapper.readValue(json,CloseBugDevRequestDto.class);
        }catch (Exception e){
            System.out.println("error is "+e.getMessage());
        }

        System.out.println(cbdDto);

        CloseBugDevResponseDto closeBugDevResponseDto = closeBugDeveloperService.closeBugDev(cbdDto);

        ObjectMapper mapObjectToJson = new ObjectMapper();

        String jsonRes = mapObjectToJson.writeValueAsString(closeBugDevResponseDto);

        System.out.println(jsonRes);


        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonRes);
        out.flush();

    }

}
