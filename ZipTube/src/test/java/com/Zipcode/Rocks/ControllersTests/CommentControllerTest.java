package com.Zipcode.Rocks.ControllersTests;

import com.Zipcode.Rocks.Controllers.CommentController;
import com.Zipcode.Rocks.Models.Comment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(controllers = CommentController.class)
@ActiveProfiles("test")
public class CommentControllerTest {
    @Autowired
    private MockMvc mockMvc;

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

//    @Test
//    public void shouldAddCommentTest() throws Exception {
//        Mockito.when(commentController.addComment(new Comment("Love It"))).thenReturn(commentList);
//        mockMvc.perform();
//    }
}
