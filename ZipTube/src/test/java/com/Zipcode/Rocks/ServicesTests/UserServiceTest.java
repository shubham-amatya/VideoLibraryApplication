package com.Zipcode.Rocks.ServicesTests;

import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Repositories.UserRepository;
import com.Zipcode.Rocks.Services.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfiguration{
        @Bean
        public UserService userService(){
            return new UserService();
        }
    }
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp(){
        User alex = new User("alex1", "alex2", "Alex", "Jones","alexj@aol.com");
//        Mockito.when(userRepository.findUserByUserName(alex.getUsername()))
//                .thenReturn(alex);
    }

    @Test
    public void findByUsernameTest() {
        String username = "alex1";
        User found = userService.getUserByUserName(username);

        assertThat(found.getUsername())
                .isEqualTo(username);
    }

}
