package com.Zipcode.Rocks.ControllersTests;

import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Services.CommentService;
import com.Zipcode.Rocks.ZipTubeApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZipTubeApplication.class)

@AutoConfigureMockMvc //(, secretKey)
@TestPropertySource(locations = {"classpath:application.properties"})

//@TestPropertySource(properties = {
//        "spring.datasource.username=${DATASOURCE_USER}",
//        "spring.datasource.password=${DATASOURCE_PW}",
//        "spring.datasource.url=${DATASOURCE_URL}",
//        "aws.endpointUrl=${endpointUrl}",
//        "aws.access_key_id=${accessKey}",
//        "aws.secret_access_key=${secretKey}",
//        "aws.bucket= ${bucket}"
//})


    @AutoConfigureMockMvc


public class CommentControllerTest {


    @Autowired
    private MockMvc mvc;


    @MockBean
    private CommentService service;

    ObjectMapper objectMapper = new ObjectMapper();

    Comment comment1;
    Comment comment2;
    Comment comment3;
    List<Comment> comments;

    @Value("${aws.endpointUrl}")
    private String endpointUrl;
    @Value("${aws.bucket}")
    private String bucketName;
    @Value("${aws.access_key_id}")
    private String accessKey;
    @Value("${aws.secret_access_key}")
    private String secretKey;
    @Value("${spring.datasource.url}")
    private String DATASOURCE_URL;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("S{spring.datasource.password}")
    private String password;


    @Before
    public void setup() {
        comment1 = new Comment("Garfield", 123L, "Wow nice!");
        comment2 = new Comment("Tom", 123L, "Ok!");
        comment3 = new Comment("Mitten", 1235L, "Wow nice!");
        comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);
    }


    @Test
    public void testGetAllComments() throws Exception {

        Mockito.when(service.getAllComments()).thenReturn(comments);
        mvc.perform(get("/comments/allcomments"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testAddComments() {
        try {
            String jsonRequest = objectMapper.writeValueAsString(comment1);
            Mockito.when(service.addComment(any())).thenReturn(comment1);
            mvc.perform(post("/comment/addcomment")
                    .content(jsonRequest)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.comment", is("Wow nice!")))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteComments() throws Exception {
        try {
            String jsonRequest = objectMapper.writeValueAsString(comment1);

//            Mockito.when(service.deleteComment(123L)).thenReturn();
//            mvc.perform(delete("/myaccount/profile/delete"))
//                    .andExpect(status().isForbidden());
//        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetCommentsByVideo() throws Exception {
       // Mockito.when(service.getCommentsByVideo(123L)).thenReturn(comment1);
        mvc.perform(get("/commentsbyvideo/{videoID}"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testUpdateComment() {
        try {
            String jsonRequest = objectMapper.writeValueAsString(comment1);
         //   Mockito.when(service.putEditComment((123L, "Wow nice!"))).thenReturn(comment1);
            mvc.perform(post("/comment/{commentId}")
                    .content(jsonRequest)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.comment", is("Wow nice!")))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
