package com.Zipcode.Rocks.ModelsTests;
import com.Zipcode.Rocks.Models.Video;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;


public class VideoTest {
    Video video;

    @Before
    public void setUp(){
      video = new Video();
    }

    @Test
    public void testVideoId(){
        setUp();
        Long expected = 123L;
        video.setVideoId(123L);
        Long actual = video.getVideoId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUserName(){
        setUp();
        String expected = "Kathmandu";
        video.setUserName(expected);
        String actual = video.getUserName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testVideoURL(){
        setUp();
        String expected ="http://meow.com/videos";
        video.setVideoURL(expected);
        String actual = video.getVideoURL();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDescription(){
        setUp();
        String expected = "Learn SpringBoot in less than 5 minutes";
        video.setDescription(expected);
        String actual = video.getDescription();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testTimePosted(){
        LocalDate expected = LocalDate.now();
        video.setVideoTimePosted(expected);
        LocalDate actual = video.getVideoTimePosted();
        Assert.assertEquals(expected, actual);
    }

}
