package com.Zipcode.Rocks.ModelsTests;

import com.Zipcode.Rocks.Models.Comment;
import com.Zipcode.Rocks.Models.Video;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class CommentTest {
    Comment comment;

        @Before
        public void setUp() {
            comment = new Comment();
        }

        @Test
        public void testCommentId() {
            setUp();
            Long expected = 12L;
            comment.setCommentId(expected);
            Long actual = comment.getCommentId();
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testCommentUserName() {
            setUp();
            String expected = "Mi Lu Le";
            comment.setUserName(expected);
            String actual = comment.getUserName();
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testCommentVideoId() {
            setUp();
            Long expected = 1L;
            comment.setVideoId(expected);
            Long actual = comment.getVideoId();
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void testComment() {
            setUp();
            String expected = "I love it!";
            comment.setComment(expected);
            String actual = comment.getComment();
            Assert.assertEquals(expected, actual);
        }


        @Test
        public void testTimePosted() {
            Date expected = new Date();
            comment.setCommentDatePosted(expected);
            Date actual = comment.getCommentDatePosted();
            Assert.assertEquals(expected, actual);
        }

    }

