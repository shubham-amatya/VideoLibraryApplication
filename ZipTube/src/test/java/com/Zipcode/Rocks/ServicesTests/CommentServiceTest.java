package com.Zipcode.Rocks.ServicesTests;

import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Services.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

//    @Test
//    public void whenVideoIdIsProvided_thenRetrieveCommentIsCorrect() {
//        String mockComment = "AS IF!!!";
//        Long id = new Long(1);
//        Mockito.when(commentService.getCommentsByVideo(id)).thenReturn(new Comment(mockComment));
//
//        String testComment = commentService.getCommentsByVideo(id).getComment();
//    }
}
