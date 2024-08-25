package org.example.bugtrackingsystem.controller.AuthController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bugtrackingsystem.Dto.Auth.UserRegisterResponseDto;
import org.example.bugtrackingsystem.models.Auth.Users;
import org.example.bugtrackingsystem.service.AuthService.UserRegisterService;

import java.io.*;

@WebServlet("/api-save-user")
public class UserRegisterController extends HttpServlet {

    UserRegisterService userAuthService = new UserRegisterService();

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

        Users u = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            u = mapper.readValue(json, Users.class);
        }catch (Exception e){
            System.out.println("error is "+e.getMessage());
        }

        int status = userAuthService.addUser(u);

        ObjectMapper mapObjectToJson = new ObjectMapper();

        String jsonRes = mapObjectToJson.writeValueAsString(new UserRegisterResponseDto(status,u.getName()));

        System.out.println(jsonRes);


        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(jsonRes);
        out.flush();

    }
}
