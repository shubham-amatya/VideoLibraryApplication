package com.Zipcode.Rocks.ServicesTests;

import com.Zipcode.Rocks.Models.Video;
import com.Zipcode.Rocks.Repositories.VideoRepository;
import com.Zipcode.Rocks.Services.VideoService;
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
public class VideoServiceTest {

    @Mock
    private VideoRepository videoRepository;

    @InjectMocks
    public VideoService videoService;

    @Test
    public void addVideoTest() {
        Video video = new Video("Best Video", "www.videos.com/123", "the best, obviously", "Janet");

        doReturn(video).when(videoRepository).save(video);

        Video expectedResponse = videoService.addVideo(video);

        assertThat(expectedResponse).isEqualTo(video);
    }


    @Test
    public void getVideoById() {
        Video video = new Video("Best Video", "www.videos.com/123", "the best, obviously", "Janet");
        video.setVideoId(1L);

        doReturn(video).when(videoRepository).findVideoByVideoId(1L);

        Video expected = videoRepository.findVideoByVideoId(1L);

        assertThat(video).isEqualTo(expected);
    }

    @Test
    public void getVideoByUsername() {
        Video video = new Video("Best Video", "www.videos.com/123", "the best, obviously", "Janet");

        doReturn(video).when(videoRepository).findVideoByUserName("Janet");

        Video expected = videoRepository.findVideoByUserName("Janet");

        assertThat(video).isEqualTo(expected);
    }

    @Test
    public void getAllVideosByUsername() {
        Video video1 = new Video("Best Video", "www.videos.com/123", "the best, obviously", "Janet");
        Video video2 = new Video("Second Best Video", "www.videos.com/1234", "almost the best", "Janet");
        List<Video> videoList = new ArrayList<>();
        videoList.add(video1);
        videoList.add(video2);

        doReturn(videoList).when(videoRepository).findAllByUserName("Janet");

        List<Video> expected = videoRepository.findAllByUserName("Janet");

        assertThat(videoList).isEqualTo(expected);
    }

    @Test
    public void getVideosByTitle() {
        Video video1 = new Video("Best Video", "www.videos.com/123", "the best, obviously", "Janet");
        Video video2 = new Video("Second Best Video", "www.videos.com/1234", "almost the best", "Janet");
        Video video3 = new Video("Cute kitties", "www.videos.com/12344", "cats play", "Suzie");
        List<Video> videoList = new ArrayList<>();
        videoList.add(video1);
        videoList.add(video2);
        videoList.add(video3);

        doReturn(videoList).when(videoRepository).findAll();

        List<Video> expected = videoRepository.findAll();

        assertThat(videoList).isEqualTo(expected);
    }

    @Test
    public void deleteVideoByIdTest() {
        Video video = new Video("Best Video", "www.videos.com/123", "the best, obviously", "Janet");
        video.setVideoId(7L);
        Long id = 7L;
        videoService.deleteVideoByVideoId(id);

        doReturn(null).when(videoRepository).findVideoByVideoId(id);

        Video expectedResponse = videoService.findVideoByVideoId(id);

        assertThat(expectedResponse).isEqualTo(null);

    }


}






