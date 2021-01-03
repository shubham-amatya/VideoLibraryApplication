package com.Zipcode.Rocks.Controllers;

import com.Zipcode.Rocks.Configurations.AwsS3Config;
import com.Zipcode.Rocks.Models.Video;
import com.Zipcode.Rocks.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("storage/")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost"})
public class VideoController {

    @Autowired
    private VideoService videoService;

    private AwsS3Config amazonClient;

    @Autowired
    VideoController(AwsS3Config amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadVideo")
    public Video uploadFile(@RequestPart(value = "video") MultipartFile file) {
        Video video = new Video();
        video.setVideoURL(this.amazonClient.uploadFile(file));
        return videoService.addVideo(video);

    }

    @DeleteMapping("/deleteVideo")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.amazonClient.deleteFileFromS3Bucket(fileUrl);
    }

//    @PostMapping("video/addvideo")
//    public ResponseEntity<Video> addVideo(@RequestBody Video video){
//        return new ResponseEntity<>(videoService.addVideo(video), HttpStatus.CREATED);}

    @DeleteMapping("deletevideo/{videoId}")
    public void deleteVideoByVideoId(@PathVariable Long videoId){videoService.deleteVideoByVideoId(videoId);}

//    @GetMapping("videobyusername/{userName}")
//    public ResponseEntity<Video> getVideoByUserName(@PathVariable String userName){return new ResponseEntity<>(videoService.getVideoByUserName(userName), HttpStatus.OK);}

    @GetMapping("allvideosbyusername/{userName}")
    public ResponseEntity<List<Video>> getAllVideoByUserName(@PathVariable String userName){
        return new ResponseEntity<>(videoService.getAllVideosByUserName(userName), HttpStatus.OK);
    }

    @GetMapping("videobytitle/{title}")
    public ResponseEntity <List<Video>> getVideoByTitle(@PathVariable String title){return new ResponseEntity<>(videoService.getVideoByTitle(title), HttpStatus.OK);}


    @PutMapping("video/{videoId}")
    public ResponseEntity<Video> updateVideoByVideoId(@RequestBody Video video, @PathVariable Long videoId){
        return new ResponseEntity<>(videoService.updateVideoByVideoId(videoId, video.getUserName(), video.getTitle(), video.getDescription()), HttpStatus.OK);
    }

}



