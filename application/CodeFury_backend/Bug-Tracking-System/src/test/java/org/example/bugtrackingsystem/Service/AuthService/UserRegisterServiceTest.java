package org.example.bugtrackingsystem.Service.AuthService;

import org.example.bugtrackingsystem.dao.BugsDao.BugImplDaoFactory;
import org.example.bugtrackingsystem.models.Auth.Users;
import org.example.bugtrackingsystem.service.AuthService.UserRegisterService;
import org.example.bugtrackingsystem.service.DeveloperPage.CloseBugDeveloperService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class UserRegisterServiceTest {

    private static UserRegisterService userRegisterService;

    @BeforeAll
    static void setUp() {
        userRegisterService = new UserRegisterService();
    }

    @AfterAll
    static void tearDown() {
        userRegisterService = null;
    }

    @Test
    @Order(1)
    public void testAddUserSuccess() {

        Users user = new Users("aman","9760964106","aman@email.redicff.com","aman#124","3456","developer");

        int status = userRegisterService.addUser(user);

        assertEquals(200, status);
    }

    @Test
    @Order(2)
    public void testAddUserAlreadyExists() {

        Users user = new Users("aman","9760964106","aman@email.redicff.com","aman#123","3456","developer");

        int status = userRegisterService.addUser(user);

        assertEquals(0, status);
    }


}
