package com.Zipcode.Rocks.ControllersTests;
import com.Zipcode.Rocks.Controllers.UserController;
import com.Zipcode.Rocks.Models.User;
import com.Zipcode.Rocks.Repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private MockMvc mvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    private JacksonTester<User> jsonUser;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(userController)
               .build();
    }

    @Test
    public void canRetrieveByUserNameWhenExists() throws Exception {
       //given
       given(userRepository.findUserByUserName("jay1"))
               .willReturn(new User("jay1", "jayjay", "Jarrell", "Wells", "jay1@aol.com"));

       //when
       MockHttpServletResponse response = mvc.perform(get("/userbyusername/jay1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
       //then
       assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       assertThat(response.getContentAsString()).isEqualTo(
               jsonUser.write(new User("jay1", "jayjay", "Jarrell", "Wells", "jay1@aol.com")).getJson());

    }

//    @Test
//    public void shouldGetUserByEmail() throws Exception {
//        setUp();
//        Mockito.when(userController.getUserByUserName("ajl1@aol.com")).thenReturn(new ResponseEntity<User>(HttpStatus.OK));
//    }


}


