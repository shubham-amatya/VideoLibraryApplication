package com.Zipcode.Rocks.ServicesTests;

import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Repositories.CommentRepository;
import com.Zipcode.Rocks.Services.CommentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;

    @InjectMocks
    public CommentService commentService;

    @Test
    public void addCommentTest() {
        Comment comment = new Comment("alex1", 1L, "great job!");

        doReturn(comment).when(commentRepository).save(comment);

        Comment expectedResponse = commentService.addComment(comment);

        assertThat(expectedResponse).isEqualTo(comment);

    }

    @Test
    public void getCommentById() {
        //given
        Comment comment = new Comment("alex1", 1L, "great job!");
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        doReturn(comment).when(commentRepository).findCommentByCommentId(1L);

        Comment expected = commentRepository.findCommentByCommentId(1L);
        //Then
        assertThat(comment).isEqualTo(expected);
    }

    @Test
    public void getCommentByVideoId() {
        //given
        Comment comment = new Comment("alex1", 1L, "great job!");
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);

        doReturn(commentList).when(commentRepository).findCommentsByVideoId(1L);

        List<Comment> expected = commentRepository.findCommentsByVideoId(1L);
        //Then
        assertThat(commentList).isEqualTo(expected);

    }

    @Test
    public void getAllComments() {
        //given
        Comment comment1 = new Comment("alex1", 1L, "great job!");
        Comment comment2 = new Comment("alex1", 2L, "great job!!");
        Comment comment3 = new Comment("alex111", 3L, "great job!!!");
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment1);
        commentList.add(comment2);
        commentList.add(comment3);

        doReturn(commentList).when(commentRepository).findAll();

        List<Comment> expected = commentRepository.findAll();
        //Then
        assertThat(commentList).isEqualTo(expected);

    }


//    @Test
//    public void deleteCommentTest() {
//        Comment comment = new Comment("alex1", 1L, "great job!");
//        comment.setCommentId(2L);
//        commentService.deleteComment(2L);
//
//        doReturn(null).when(commentRepository).findCommentByCommentId(2L);
//
//        Comment expected = commentRepository.findCommentByCommentId(2L);
//
//        assertThat(comment).isEqualTo(null);
//    }

}





