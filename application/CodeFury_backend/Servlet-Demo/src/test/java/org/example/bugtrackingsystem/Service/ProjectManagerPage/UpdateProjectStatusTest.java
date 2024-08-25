package org.example.bugtrackingsystem.Service.ProjectManagerPage;

import org.example.bugtrackingsystem.Dto.ProjectManagerPage.UpdateProjectStatus.UpdateProjectStatusRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.UpdateProjectStatus.UpdateProjectStatusResponseDto;
import org.example.bugtrackingsystem.service.ProjectMangerPage.CloseBugPmService;
import org.example.bugtrackingsystem.service.ProjectMangerPage.UpdateProjectStatusService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateProjectStatusTest {

    private static UpdateProjectStatusService updateProjectStatusService;

    @BeforeAll
    public static void setUp(){
        updateProjectStatusService = new UpdateProjectStatusService();
    }
    @AfterAll
    public static void tearDown() {
        updateProjectStatusService = null;
    }

    @Test
    public void testUpdateProjectStatusSuccess() {

        UpdateProjectStatusRequestDto requestDto = new UpdateProjectStatusRequestDto("proj2");

        UpdateProjectStatusResponseDto responseDto = updateProjectStatusService.updateProjectStatus(requestDto);

        assertEquals(200, responseDto.getStatus());
    }

}
