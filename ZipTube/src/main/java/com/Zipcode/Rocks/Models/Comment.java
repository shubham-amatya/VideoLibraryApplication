package com.Zipcode.Rocks.Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long commentId;
    private Long userId;
    private String userName;
    private Long videoId;
    private String comment;
    private Timestamp commentTimePosted;

    public Comment(){}

    public Comment(Long userId, String userName, Long videoId, String comment) {
        this.userId = userId;
        this.userName = userName;
        this.videoId = videoId;
        this.comment = comment;
        Date date = new Date();
        this.commentTimePosted = new Timestamp(date.getTime());
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCommentTimePosted() {
        return commentTimePosted;
    }

    public void setCommentTimePosted(Timestamp commentTimePosted) {
        this.commentTimePosted = commentTimePosted;
    }
}
