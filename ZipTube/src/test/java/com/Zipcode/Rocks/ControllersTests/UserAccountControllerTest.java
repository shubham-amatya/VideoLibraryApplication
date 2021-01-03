package com.Zipcode.Rocks.ControllersTests;
import com.Zipcode.Rocks.Controllers.UserController;
import com.Zipcode.Rocks.Services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserAccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;


    @Test
    public void testGetCommentsListSuccess() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/user/jay1";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        assertThat(result.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void testGetCommentsListComment() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/commentsbyvideo/1";
        URI uri = new URI(baseUrl);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        assertThat(result.getBody()).contains("Yes!!!");
    }
}

//    @Test
//    public void findAllUsersTest()
//            throws Exception {

//        User alex = new User("a1", "a2", "Alex", "Jones","a@aol.com");
//        BDDMockito
//        .given(service.getUserByEmail("a2")).willReturn(alex);
//
//        mvc.perform(MockMvcRequestBuilders.get("/user/")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is(alex.getEmail())));}


//    @Test
//    public void addUserTest() throws Exception {
//        User user = new User("HiThere1", "H!Th3r3!", "Heidi", "James", "heja@aol.com");
//        BDDMockito
//                .given(repository.save(user))
//                .willReturn(user);
//
//        String expectedContent = "{\"id\":null,\"username\":HiThere1,\"password\":H!Th3r3!,\"firstName\":Heidi,\"lastName\":James,\"email\":heja@aol.com}";
//
//        this.mvc.perform(MockMvcRequestBuilders
//                .post("/user/adduser")
//                .content(expectedContent)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
//    }
//    @Test
//    public void getUserbyUserNameTest() throws Exception {
//        String givenUsername = "HiThere";
//        BDDMockito
//                .given(repository.findUserByUserName("HiThere"))
//                .willReturn(Optional.of(new User("HiThere", null, null, null, null)));
//
//        String expectedContent = "{\"id\":null,\"username\":\"HiThere\",\"password\":null,\"firstName\":null,\"lastName\":null,\"email\":null}";
//        this.mvc.perform(MockMvcRequestBuilders
//                .get("/user/" + givenUsername))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string(expectedContent)); }





