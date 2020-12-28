package com.Zipcode.Rocks.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long commentId;
    private String userName;
    private Long videoId;
    private String comment;
    @Temporal(TemporalType.DATE)
    private Date commentDatePosted;

    public Comment(){}

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(String userName, Long videoId, String comment) {
        this.userName = userName;
        this.videoId = videoId;
        this.comment = comment;

    }

    public Long getCommentId() { return commentId; }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    public Date getCommentDatePosted() { return commentDatePosted; }

    public void setCommentDatePosted(Date commentDatePosted) { this.commentDatePosted = commentDatePosted; }
}

