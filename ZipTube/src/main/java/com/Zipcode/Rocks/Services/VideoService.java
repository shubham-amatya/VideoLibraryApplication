package com.Zipcode.Rocks.Services;


import com.Zipcode.Rocks.Models.Video;
import com.Zipcode.Rocks.Repositories.UserRepository;
import com.Zipcode.Rocks.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private UserRepository userRepository;

    public Video addVideo(Video video) {
        video.setVideoTimePosted(new Date());
        return videoRepository.save(video);
    }

    public Video getVideoByVideoId(Long videoId) {
        return videoRepository.findVideoByVideoId(videoId);
    }

    public Video getVideoByUserName(String username) {
        return videoRepository.findVideoByUserName(username);
    }

    public List<Video> getAllVideosByUserName(String username) {
        return videoRepository.findAllByUserName(username);
    }

    public List<Video> getVideoByTitle(String title) {
        return videoRepository.findVideoByTitle(title);
    }

    public void deleteVideoByVideoId(Long videoId) {
        videoRepository.delete(findVideoByVideoId(videoId));
    }

    public Video findVideoByVideoId(Long videoId) {
        return videoRepository.findVideoByVideoId(videoId);
    }

    public Video updateVideoByVideoId(Long videoId, Video video) {
        Video videoUpdate = getVideoByVideoId(videoId);
        videoUpdate.setTitle(video.getTitle());
        videoUpdate.setDescription(video.getDescription());
        videoUpdate.setUserName(video.getUserName());
        return videoRepository.save(videoUpdate);
    }

}
