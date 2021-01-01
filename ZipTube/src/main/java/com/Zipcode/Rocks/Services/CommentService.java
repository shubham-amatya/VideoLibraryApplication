package com.Zipcode.Rocks.Services;

import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment addComment(Comment comment){
        comment.setCommentDatePosted(new Date());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId){
        commentRepository.delete(commentRepository.findCommentByCommentId(commentId));
    }

    public Comment putEditComment(Long commentId, String stringComment){
        Comment comment = commentRepository.findCommentByCommentId(commentId);
        comment.setComment(stringComment);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByVideo(Long videoId){
        return commentRepository.findCommentsByVideoId(videoId);
    }
}
