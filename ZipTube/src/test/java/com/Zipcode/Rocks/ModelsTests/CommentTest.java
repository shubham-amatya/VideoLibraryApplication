package com.Zipcode.Rocks.ModelsTests;

import com.Zipcode.Rocks.Models.Comment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class CommentTest {
    Comment comment;

    @Before
    public void setup() {
        comment = new Comment();
    }

    @Test
    public void testCommentId() {
        Long expected = 123L;
        comment.setCommentId(expected);
        Long actual = comment.getCommentId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUserName() {
        String expected = "panders632";
        comment.setUserName(expected);
        String actual = comment.getUserName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testVideoId() {
        Long expected = 123L;
        comment.setVideoId(expected);
        Long actual = comment.getVideoId();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testComment() {
        String expected = "Nice";
        comment.setComment(expected);
        String actual = comment.getComment();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDate() {
        Date expected = new Date();
        comment.setCommentDatePosted(expected);
        Date actual = comment.getCommentDatePosted();
        Assert.assertEquals(expected, actual);
    }
}
