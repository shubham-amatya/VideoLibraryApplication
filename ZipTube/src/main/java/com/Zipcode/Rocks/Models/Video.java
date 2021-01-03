package com.Zipcode.Rocks.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Video {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long videoId;
    private String userName;
    private String title;
    private String videoURL;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date videoTimePosted;


    public Video() {
    }

    public Video(String title, String videoURL, String description, String userName) {
        this.title = title;
        this.videoURL = videoURL;
        this.description = description;
        this.userName = userName;
    }

    public Long getVideoId() {
        return videoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getVideoTimePosted() { return videoTimePosted; }

    public void setVideoTimePosted(Date videoTimePosted) { this.videoTimePosted = videoTimePosted; }
}
