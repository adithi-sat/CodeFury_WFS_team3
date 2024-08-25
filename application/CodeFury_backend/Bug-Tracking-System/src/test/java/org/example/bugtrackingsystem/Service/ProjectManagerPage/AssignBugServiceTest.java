package org.example.bugtrackingsystem.Service.ProjectManagerPage;

import org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug.AssignBugRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectManagerPage.AssignBug.AssignBugResponseDto;
import org.example.bugtrackingsystem.dao.AuthDao.UserFactory;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDaoImplFactory;
import org.example.bugtrackingsystem.service.ProjectAndBugDetailService.ProjectBugDetailsService;
import org.example.bugtrackingsystem.service.ProjectMangerPage.AssignBugService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignBugServiceTest {

    private static AssignBugService assignBugService;
    private static BugDao bugDao;

    @BeforeAll
    public static void setUp(){
        assignBugService = new AssignBugService();
        bugDao = BugImplDaoFactory.getBugDaoImpl("jdbc");
    }

    @AfterAll
    public static void tearDown() {
        bugDao = null;
        assignBugService = null;
    }

    @Test
    public void testAssignBugSuccess() {
        AssignBugRequestDto requestDto = new AssignBugRequestDto("aman@182", "proj1", "B_101");
        AssignBugResponseDto responseDto = assignBugService.assignBug(requestDto);

        assertEquals(200, responseDto.getStatus());
    }

}
