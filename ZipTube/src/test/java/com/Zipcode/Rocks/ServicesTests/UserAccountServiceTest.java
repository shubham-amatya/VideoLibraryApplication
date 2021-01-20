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
    public void findUserByUsernameTest() {
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
    public void findUserById() {
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
    public void findByUserByEmailTest() {
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
    public void checkUserNameExistsTest() {
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");
        String usernameGiven = "alex1";
        String response = "DOES NOT EXIST";

        doReturn(null).when(userRepository).findUserByUserName(usernameGiven);

        String expectedResponse = userService.getCheckUserNameExists(usernameGiven);

        assertThat(expectedResponse).isEqualTo(response);

    }

    @Test
    public void checkEmailExistsTest() {
        User user = new User("alex1", "1234", "Alex", "Jones", "alexj@aol.com");
        String emailGiven = "alexj@aol.com";

        doReturn(user).when(userRepository).findUserByUserName(emailGiven);

        String expectedResponse = userService.getCheckUserNameExists(emailGiven);

        assertThat(expectedResponse).isEqualTo(emailGiven);

    }

}
