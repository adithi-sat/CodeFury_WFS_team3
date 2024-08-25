package org.example.bugtrackingsystem.Service.ProjectManagerPage;

import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject.CreateProjectRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject.CreateProjectResponseDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CreateProject.Team;
import org.example.bugtrackingsystem.service.ProjectMangerPage.CloseBugPmService;
import org.example.bugtrackingsystem.service.ProjectMangerPage.CreateProjectService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateProjectServiceTest {

    private static CreateProjectService createProjectService;

    @BeforeAll
    public static void setUp(){
        createProjectService = new CreateProjectService();
    }
    @AfterAll
    public static void tearDown() {
        createProjectService = null;
    }

    @Test
    public void testAddProjectSuccess() {
        Team team1 = new Team("akshara_123$23", "Developer");
        Team team2 = new Team("arsh$182", "Tester");
        List<Team> teamMembers = Arrays.asList(team1, team2);

        CreateProjectRequestDto requestDto = new CreateProjectRequestDto("proj123", "New Project", "Project Description",
                "25-08-2024", "30-08-2024", "In Progress", "aman@182", teamMembers);

        CreateProjectResponseDto responseDto = createProjectService.addProject(requestDto);

        assertEquals(200, responseDto.getStatus());
    }

    @Test
    public void testAddProjectRuntimeException() {

        Team team1 = new Team("user1", "Developer");//does not exist in the Users table so violation of referential integrity constraint so exception would be raised
        List<Team> teamMembers = Arrays.asList(team1);

        CreateProjectRequestDto requestDto = new CreateProjectRequestDto("proj125", "Project With Exception", "Description",
                "25-08-2024", "30-08-2024", "closed", "aman$182", teamMembers);

        assertThrows(RuntimeException.class, () -> createProjectService.addProject(requestDto));
    }

}
