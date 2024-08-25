package org.example.bugtrackingsystem.controller.AuthController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bugtrackingsystem.Dto.Auth.UserValidationRequestDto;
import org.example.bugtrackingsystem.Dto.Auth.UserValidationResponseDto;
import org.example.bugtrackingsystem.service.AuthService.UserValidationService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

@WebServlet("/api-validate-user")
public class UserValidationController extends HttpServlet {

    UserValidationService userValidationService = new UserValidationService();

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

        UserValidationRequestDto u = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            u = mapper.readValue(json, UserValidationRequestDto.class);
        }catch (Exception e){
            System.out.println("error is "+e.getMessage());
        }

        UserValidationResponseDto userValidationResponseDto = userValidationService.validateUser(u);

        ObjectMapper mapObjectToJson = new ObjectMapper();

        String jsonRes = mapObjectToJson.writeValueAsString(userValidationResponseDto);

        System.out.println(jsonRes);


        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonRes);
        out.flush();

    }

}
