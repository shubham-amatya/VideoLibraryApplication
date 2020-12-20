package com.Zipcode.Rocks.Controllers;

import com.Zipcode.Rocks.Models.Video;
import com.Zipcode.Rocks.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("video/addvideo")
    public ResponseEntity<Video> addVideo(@RequestBody Video video){
        return new ResponseEntity<>(videoService.addVideo(video), HttpStatus.CREATED);}

    @DeleteMapping("deletevideo/{videoId}")
    public void deleteVideoByVideoId(@PathVariable Long videoId){videoService.deleteVideoByVideoId(videoId);}

    @GetMapping("video/{userName}")
    public ResponseEntity<Video> getVideoByUserName(@PathVariable String userName){return new ResponseEntity<>(videoService.getVideoByUserName(userName), HttpStatus.OK);}

    @GetMapping("video/{title}")
    public ResponseEntity <List<Video>> getVideoByTitle(@PathVariable String title){return new ResponseEntity<>(videoService.getVideoByTitle(title), HttpStatus.OK);}


    @PutMapping("video/{videoId}")
    public ResponseEntity<Video> updateVideoByVideoId(@RequestBody Video video, @PathVariable Long videoId){
        return new ResponseEntity<>(videoService.updateVideoByVideoId(videoId,  video.getTitle(), video.getDescription()), HttpStatus.OK);
    }








}



