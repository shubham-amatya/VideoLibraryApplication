package com.Zipcode.Rocks.Controllers;

import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("comment/addcomment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentService.addComment(comment), HttpStatus.CREATED);
    }

    @DeleteMapping("deletecomment/{commentID}")
    public void deleteCommentById(@PathVariable Long commentID){
        commentService.deleteComment(commentID);
    }

    @GetMapping("commentsbyvideo/{videoID}")
    public ResponseEntity<List<Comment>> getCommentsByVideoID(@PathVariable Long videoID){
        return new ResponseEntity<>(commentService.getCommentsByVideo(videoID), HttpStatus.OK);
    }

    @PutMapping("comment/{commentID}")
    public ResponseEntity<Comment> updateUser(@RequestBody Comment comment, @PathVariable Long commentID) {
        return new ResponseEntity<>(commentService.putEditComment(commentID, comment.getComment()), HttpStatus.OK);
    }
}
