package com.Zipcode.Rocks.ControllersTests;

import com.Zipcode.Rocks.Controllers.CommentController;
import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Services.CommentService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.client.ExpectedCount.times;

@WebMvcTest(controllers = CommentController.class)
@ActiveProfiles("test")
public class CommentControllerTest {

    @Mock
    CommentService mock;

   //@Autowired
    private MockMvc mockMvc;

    //No clue what this do//Look up verify on mockito look up mockMVC
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @MockBean
    private CommentController commentController;

    private List<Comment> commentList;

    @Before
    public void setup() {
        commentController = Mockito.mock(CommentController.class);
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
        this.commentList = new ArrayList<>();
        this.commentList.add(new Comment("really nice"));
        this.commentList.add(new Comment("Awesome work!"));
        this.commentList.add(new Comment("too funny"));
    }

    @Test
    public void shouldAddCommentTest() throws Exception {
    }
}
