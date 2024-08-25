package org.example.bugtrackingsystem.Service.ProjectAndBugDetailsService;

import org.example.bugtrackingsystem.Dto.ProjectAndBugDetailsDto.ProjectBugRequestDto;
import org.example.bugtrackingsystem.Dto.ProjectAndBugDetailsDto.ProjectBugResponseDto;
import org.example.bugtrackingsystem.dao.AuthDao.UserDao;
import org.example.bugtrackingsystem.dao.AuthDao.UserFactory;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDao;
import org.example.bugtrackingsystem.dao.ProjectDetailsDao.ProjectDaoImplFactory;
import org.example.bugtrackingsystem.service.ProjectAndBugDetailService.ProjectBugDetailsService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectBugDetailsServiceTest {

    static private ProjectBugDetailsService service;
    static private ProjectDao projectDao;
    static private UserDao userDao;
    static private BugDao bugDao;

    @BeforeAll
    public static void setUp(){
        service = new ProjectBugDetailsService();

        // Assuming the database is pre-populated with the necessary data for these tests.
        projectDao = ProjectDaoImplFactory.getProjectDaoImpl("jdbc");
        userDao = UserFactory.getUserDaoImpl("jdbc");
        bugDao = BugImplDaoFactory.getBugDaoImpl("jdbc");
    }

    @AfterAll
    public static void tearDown() {
        // Clean up resources
        projectDao = null;
        userDao = null;
        bugDao = null;
        service = null;
    }

    @Test
    public void testGetProjectBugDetailsForProjectManager() throws Exception {
        // Arrange
        ProjectBugRequestDto requestDto = new ProjectBugRequestDto();
        requestDto.setRole("project manager");
        requestDto.setProjId("proj1");
        requestDto.setUserId("aman@182");

        // Act
        ProjectBugResponseDto responseDto = service.getProjectBugDetails(requestDto);

        // Assert
        assertEquals(200, responseDto.getStatus());
        assertEquals("proj1", responseDto.getProjId());
        assertNotNull(responseDto.getBugDetails());
        assertTrue(responseDto.getBugDetails().size() > 0);
        assertEquals("Aman", responseDto.getProjPmName());
    }

    @Test
    public void testGetProjectBugDetailsForDeveloper() throws Exception {
        // Arrange
        ProjectBugRequestDto requestDto = new ProjectBugRequestDto();
        requestDto.setRole("developer");
        requestDto.setProjId("proj1"); // Example project ID
        requestDto.setUserId("akshara_123$23");  // Example developer ID

        // Act
        ProjectBugResponseDto responseDto = service.getProjectBugDetails(requestDto);

        // Assert
        assertEquals(200, responseDto.getStatus());
        assertEquals("proj1", responseDto.getProjId());
        assertTrue(responseDto.getBugDetails().size() >= 0);
    }

    @Test
    public void testGetProjectBugDetailsForTester() throws Exception {
        // Arrange
        ProjectBugRequestDto requestDto = new ProjectBugRequestDto();
        requestDto.setRole("tester");
        requestDto.setProjId("proj1"); // Example project ID
        requestDto.setUserId("arsh$182"); // Example tester ID

        // Act
        ProjectBugResponseDto responseDto = service.getProjectBugDetails(requestDto);

        // Assert
        assertEquals(200, responseDto.getStatus());
        assertEquals("proj1", responseDto.getProjId());
        assertNotNull(responseDto.getBugDetails());
        assertTrue(responseDto.getBugDetails().size() > 0);
    }

    @Test
    public void testGetProjectBugDetailsWithInvalidRole() {
        // Arrange
        ProjectBugRequestDto requestDto = new ProjectBugRequestDto();
        requestDto.setRole("invalid role");
        requestDto.setProjId("PROJ_001");
        requestDto.setUserId("USER_001");

        // Act
        ProjectBugResponseDto responseDto = service.getProjectBugDetails(requestDto);

        // Assert
        assertEquals(-1, responseDto.getStatus());
    }

    @Test
    public void testGetProjectBugDetailsFailure() throws SQLException, ClassNotFoundException {
        // Given
        ProjectBugRequestDto requestDto = new ProjectBugRequestDto();
        requestDto.setProjId("NonExistentProject");  // Assuming this project ID doesn't exist
        requestDto.setRole("project manager");
        requestDto.setUserId("aman@182");
        // When
        ProjectBugResponseDto responseDto = service.getProjectBugDetails(requestDto);

        // Then
        assertNotNull(responseDto);
        assertEquals(-1, responseDto.getStatus());
    }

}
