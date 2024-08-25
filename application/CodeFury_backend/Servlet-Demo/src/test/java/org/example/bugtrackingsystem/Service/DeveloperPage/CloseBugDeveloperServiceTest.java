package org.example.bugtrackingsystem.Service.DeveloperPage;

import org.example.bugtrackingsystem.Dto.DeveloperPage.CloseBugDevRequestDto;
import org.example.bugtrackingsystem.Dto.DeveloperPage.CloseBugDevResponseDto;
import org.example.bugtrackingsystem.dao.BugsDao.BugDao;
import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;
import org.example.bugtrackingsystem.service.DeveloperPage.CloseBugDeveloperService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CloseBugDeveloperServiceTest {
    private static CloseBugDeveloperService closeBugDeveloperService;
    private static BugDao bugDao;

    @BeforeAll
    static void setUp() {
        bugDao = BugImplDaoFactory.getBugDaoImpl("jdbc");
        closeBugDeveloperService = new CloseBugDeveloperService();
    }

    @AfterAll
    static void tearDown() {
        // Clean up resources after all tests are done
        closeBugDeveloperService = null;
        bugDao = null;
    }

    @Test
    void testCloseBugDev_Success() {
        // Arrange
        CloseBugDevRequestDto requestDto = new CloseBugDevRequestDto("proj1", "B_101");

        // Act
        CloseBugDevResponseDto response = closeBugDeveloperService.closeBugDev(requestDto);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("B_101 is closed by dev", response.getDesc());
    }

    @Test
    void testCloseBugDev_Failure() {
        // Arrange
        CloseBugDevRequestDto requestDto = new CloseBugDevRequestDto("invalidProject", "invalidBug");

        // Act
        CloseBugDevResponseDto response = closeBugDeveloperService.closeBugDev(requestDto);

        // Assert
        assertEquals(200, response.getStatus());
        assertEquals("invalidBug is closed by dev", response.getDesc());
    }

}
