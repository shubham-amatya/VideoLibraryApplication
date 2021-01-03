package com.Zipcode.Rocks.Repositories;

import com.Zipcode.Rocks.Models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findAllByUserName(String username);

//    // custom query to search to videos post by title or description
//    List<Video> findByTitleContainingOrContentContaining(String title, String description);

        Video findVideoByUserName(String username);

        Video findVideoByVideoId(Long videoId);

        List<Video> findVideoByTitle(String title);


    }

//    // custom query to search to blog post by title or content
//    List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);