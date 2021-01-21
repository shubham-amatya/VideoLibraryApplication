package com.Zipcode.Rocks.ControllersTests;

import com.Zipcode.Rocks.Controllers.CommentController;
import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Services.CommentService;
import com.Zipcode.Rocks.Services.UserService;
import com.Zipcode.Rocks.ZipTubeApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZipTubeApplication.class)
@AutoConfigureMockMvc

public class CommentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CommentService service;

    Comment comment1;
    Comment comment2;
    Comment comment3;
    List<Comment> comments;



    @Before
    public void setup(){
        comment1 = new Comment("Garfield", 123L, "Wow nice!");
        comment2 = new Comment("Tom", 123L, "Ok!");
        comment3 = new Comment("Mitten", 1235L, "Wow nice!");
        comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);
        }

    //@WithMockUser

    @Test
    public void testGetAllComments() throws Exception {

        Mockito.when(service.getAllComments()).thenReturn(comments);
        mvc.perform(get("/comments/allcomments"))
                    .andExpect(status().isOk())
                    .andReturn();

    }






}
