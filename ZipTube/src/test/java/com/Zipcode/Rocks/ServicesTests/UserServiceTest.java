package com.Zipcode.Rocks.ServicesTests;

import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = ZipTubeApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class UserServiceTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private UserService userService;

    @Test
    public void whenUserDeletedById_checkUserExistsByUsernameNull(){
        User mockUser = new User("jay1", "pwd321", "jarrell", "wells", "jay@zipstudio.com");
        mockUser.setUserId(2L);
        userService.deleteUserByUserId(2L);
        User expectedUser = null;
        Assert.assertEquals(expectedUser, userService.getUserByUserId(2L));
    }

    @Test
    public void whenUserIdGiven_RetrievedUserById() {
        User mockUser = new User("jay1", "pwd321", "jarrell", "wells", "jay@zipstudio.com");
        mockUser.setUserId(2L);
        Long expectedUserId = 2L;
        Mockito.when(userService.getUserByUserId(expectedUserId)).thenReturn(mockUser);

        Assert.assertEquals(mockUser, userService.getUserByUserId(2L));
    }

    @Test
    public void whenUserDeletedByUsername_thenRetrievedByUserNameIsNull(){
        User mockUser = new User("jay1", "pwd321", "jarrell", "wells", "jay@zipstudio.com");
        String mockUsername = mockUser.getUsername();
        User expectedUser = null;
        userService.deleteUserByUserName(mockUsername);

        Assert.assertEquals(expectedUser, userService.getUserByUserName(mockUsername));
        }

    @Test
    public void whenUsernameIsProvided_thenRetrievedUsernameIsCorrect(){
        User mockUser = new User("jay1", "pwd321", "jarrell", "wells", "jay@zipstudio.com");
        String expectedUsername = "jay1";
        Mockito.when(userService.getUserByUserName(expectedUsername)).thenReturn(mockUser);

        User actualUser = userService.getUserByUserName(expectedUsername);
        Assert.assertEquals(expectedUsername, actualUser.getUsername());
    }

    @Test
    public void whenUserEmailIsProvided_thenRetrievedUserEmailIsCorrect(){
        User mockUser = new User("jay1", "pwd321", "jarrell", "wells", "jay@zipstudio.com");
        String expectedEmail = "jay@zipstudio.com";
        Mockito.when(userService.getUserByEmail(expectedEmail)).thenReturn(mockUser);

        User actualUser = userService.getUserByEmail(expectedEmail);
        Assert.assertEquals(expectedEmail, actualUser.getEmail());
    }

    @Test
    public void whenUserAdded_GetUserNameExists(){
        userService.addUser(new User("jay1", "pwd321", "jarrell", "wells", "jay@zipstudio.com"));
        String expectedUserName = "jay1";

        Mockito.when(userService.getCheckUserNameExists("jay1")).thenReturn(expectedUserName);
        String testUsername = userService.getCheckUserNameExists(expectedUserName);

        Assert.assertEquals(expectedUserName, testUsername);
    }

    @Test
    public void whenUserEmailUpdated_RetrievedUserEmailIsUpdated() {
       User newUser = new User("jay1", "pwd321", "jarrell", "wells", "jay@zipstudio.com");
       userService.putUserUpdate("jay1", "pwd321", "jarrell", "wells", "jayjay@zipstudio.com");
       String expectedEmail = "jayjay@zipstudio.com";
       Mockito.when(userService.getCheckUserEmailExists("jayjay@zipstudio.com")).thenReturn(expectedEmail);
       String testEmail = userService.getCheckUserEmailExists(expectedEmail);

        Assert.assertEquals(expectedEmail, testEmail);
    }

    @Test
    public void whenUserNameIsProvided_thenUsernameCheckedIfExists(){
        String mockUserName = "jay1";
        String expectedUserName = "jay1";

        Mockito.when(userService.getCheckUserNameExists(mockUserName)).thenReturn(new User(mockUserName, "pwd321", "jarrell", "wells", "jay@zipstudio.com").getUsername());
        String testUsername = userService.getCheckUserNameExists(mockUserName);

        Assert.assertEquals(expectedUserName, testUsername);
    }

    @Test
    public void whenUserNameIsProvided_thenUsernameCheckedDoesNotExist(){
        String mockUserName = "kelly1";
        String expectedResult = "DOES NOT EXIST";

        Mockito.when(userService.getCheckUserNameExists(mockUserName)).thenReturn(expectedResult);
        String testUsername = userService.getCheckUserNameExists(mockUserName);

        Assert.assertEquals(expectedResult, testUsername);
    }

    @Test
    public void whenEmailIsProvided_thenEmailCheckedIfExists(){
        String mockEmail = "jay@zipstudio.com";
        String expectedEmail = "jay@zipstudio.com";

        Mockito.when(userService.getCheckUserNameExists(mockEmail)).thenReturn(new User("jay1", "pwd321", "jarrell", "wells", mockEmail).getEmail());
        String testEmail = userService.getCheckUserNameExists(mockEmail);

        Assert.assertEquals(expectedEmail, testEmail);
    }

    @Test
    public void whenEmailIsProvided_thenEmailCheckedDoesNotExist(){
        String mockEmail = "kelly1@aol.com";
        String expectedEmail = "DOES NOT EXIST";

        Mockito.when(userService.getCheckUserNameExists(mockEmail)).thenReturn(expectedEmail);
        String testEmail = userService.getCheckUserNameExists(mockEmail);

        Assert.assertEquals(expectedEmail, testEmail);
    }
}

