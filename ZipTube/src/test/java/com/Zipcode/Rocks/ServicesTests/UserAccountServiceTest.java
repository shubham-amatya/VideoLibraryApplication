package com.Zipcode.Rocks.ServicesTests;

import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Repositories.UserRepository;
import com.Zipcode.Rocks.Services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserAccountServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    public UserService userService;


    @Test
    public void getUserByUsernameTest() {
        //given
        String username = "alex1";
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");

        doReturn(user).when(userRepository).findUserByUserName(username);

        //when
        User actualUser = userService.getUserByUserName(username);

        //Then
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    public void getUserById() {
        //given
        Long userId = 1L;
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");
        user.setUserId(userId);

        doReturn(user).when(userRepository).findUserByUserId(userId);

        //when
        User actualUser = userService.getUserByUserId(userId);

        //Then
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    public void getByUserByEmailTest() {
        //given
        String email = "alexj@aol.com";
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");

        doReturn(user).when(userRepository).findUserByEmail(email);

        //when
        User actualUser = userService.getUserByEmail(email);

        //Then
        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    public void checkUsernameExistsTest() {
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");
        String usernameGiven = "alex1";

        doReturn(user).when(userRepository).findUserByUserName(usernameGiven);

        String expectedResponse = userService.getCheckUserNameExists(usernameGiven);

        assertThat(expectedResponse).isEqualTo(usernameGiven);

    }

    @Test
    public void checkEmailExistsTest() {
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");
        String emailGiven = "alexj@aol.com";

        doReturn(user).when(userRepository).findUserByUserName(emailGiven);

        String expectedResponse = userService.getCheckUserNameExists(emailGiven);

        assertThat(expectedResponse).isEqualTo(emailGiven);

    }

    @Test
    public void addUserTest() {
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");

        doReturn(user).when(userRepository).save(user);

        User expectedResponse = userService.addUser(user);

        assertThat(expectedResponse).isEqualTo(user);

    }



    @Test
    public void deleteUserByUsernameTest() {
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");
        String username = "alex1";
        userService.deleteUserByUserName(username);
        String response = "DOES NOT EXIST";

        doReturn(null).when(userRepository).findUserByUserName(username);

        String expectedResponse = userService.getCheckUserNameExists(username);

        assertThat(expectedResponse).isEqualTo(response);

    }

    @Test
    public void deleteUserByIdTest() {
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");
        user.setUserId(7L);
        Long id = 7L;
        userService.deleteUserByUserId(id);

        doReturn(null).when(userRepository).findUserByUserId(id);

       User expectedResponse = userService.getUserByUserId(id);

        assertThat(expectedResponse).isEqualTo(null);

    }

//    @Test
//    public void updateNameTest() {
//        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");
//        user.setUserId(6L);
//
//        doReturn(user).when(userRepository).save(user);
//
//        User expectedResponse = userService.putUpdateName("alex1", "Alexander", "Jones");
//
//        assertThat(user).isEqualTo(expectedResponse);
//
//    }

}
