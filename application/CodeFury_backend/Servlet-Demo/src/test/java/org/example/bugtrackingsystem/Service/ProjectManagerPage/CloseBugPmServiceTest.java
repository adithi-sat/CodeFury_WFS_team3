package org.example.bugtrackingsystem.Service.ProjectManagerPage;

import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.CloseBug.CloseBugPmResponseDto;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;
import org.example.bugtrackingsystem.service.ProjectMangerPage.AssignBugService;
import org.example.bugtrackingsystem.service.ProjectMangerPage.CloseBugPmService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloseBugPmServiceTest {

    private static CloseBugPmService closeBugPmService;

    @BeforeAll
    public static void setUp(){
        closeBugPmService = new CloseBugPmService();
    }
    @AfterAll
    public static void tearDown() {
        closeBugPmService = null;
    }

    @Test
    public void testCloseBugPmSuccess() {
        CloseBugPmRequestDto requestDto = new CloseBugPmRequestDto("proj1", "B_101");
        CloseBugPmResponseDto responseDto = closeBugPmService.closeBugPm(requestDto);

        assertEquals(200, responseDto.getStatus());
    }

    @Test
    public void testCloseBugPmNotClosedByDeveloper() {
        CloseBugPmRequestDto requestDto = new CloseBugPmRequestDto("proj1", "B_100");
        CloseBugPmResponseDto responseDto = closeBugPmService.closeBugPm(requestDto);

        assertEquals(0, responseDto.getStatus());
    }



}
