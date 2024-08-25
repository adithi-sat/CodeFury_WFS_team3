package org.example.bugtrackingsystem.Service.TesterPage;

import org.example.bugtrackingsystem.Dto.TesterPage.ReportingBug.ReportBugRequestDto;
import org.example.bugtrackingsystem.Dto.TesterPage.ReportingBug.ReportBugResponseDto;
import org.example.bugtrackingsystem.Utils.Exceptions.ProjectMarkedDoneException;
import org.example.bugtrackingsystem.service.ProjectMangerPage.UpdateProjectStatusService;
import org.example.bugtrackingsystem.service.TesterPage.BugReportService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BugReportServiceTest {

    private static BugReportService bugReportService;

    @BeforeAll
    public static void setUp(){
        bugReportService = new BugReportService();
    }
    @AfterAll
    public static void tearDown() {
        bugReportService = null;
    }

    @Test
    public void testReportingBugSuccess() {

        ReportBugRequestDto requestDto = new ReportBugRequestDto(
                "arsh$182", "26-08-2024", "Bug description", "High", "proj123", "dev456");

        ReportBugResponseDto responseDto = bugReportService.reportingBug(requestDto);

        assertEquals(200, responseDto.getStatus());
    }

    @Test
    public void testReportingBugFailure() {

        ReportBugRequestDto requestDto = new ReportBugRequestDto(
                "user1", "25-08-2024", "Bug description", "High", "proj46", "dev456");

        assertThrows(RuntimeException.class, () -> bugReportService.reportingBug(requestDto));

    }

    @Test
    public void testReportBugException(){
        ReportBugRequestDto requestDto = new ReportBugRequestDto(
                "arsh$182", "26-08-2024", "Bug description", "High", "proj3", "dev456");

        ReportBugResponseDto responseDto = bugReportService.reportingBug(requestDto);

        assertEquals(-1, responseDto.getStatus());
    }

}
