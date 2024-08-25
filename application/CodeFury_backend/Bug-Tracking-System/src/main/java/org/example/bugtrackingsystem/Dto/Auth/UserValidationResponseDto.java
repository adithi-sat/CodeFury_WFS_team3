package org.example.bugtrackingsystem.Dto.Auth;

import org.example.bugtrackingsystem.Dto.Auth.UserValidationResponseBody;
import org.example.bugtrackingsystem.models.ProjectDetails.ResponseProjectDto;

import java.util.List;

public class UserValidationResponseDto {
    private int status;
    private UserValidationResponseBody body;
    private List<ResponseProjectDto> projectList;

    public UserValidationResponseDto() {
    }

    public UserValidationResponseDto(int status, UserValidationResponseBody body,List<ResponseProjectDto> projectList) {
        this.status = status;
        this.body = body;
        this.projectList = projectList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResponseProjectDto> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ResponseProjectDto> projectList) {
        this.projectList = projectList;
    }

    public UserValidationResponseBody getBody() {
        return body;
    }

    public void setBody(UserValidationResponseBody body) {
        this.body = body;
    }
}
