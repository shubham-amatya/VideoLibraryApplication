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
    List<Video> findByTitleContainingOrDescriptionContaining(String text, String textAgain);

        Video findVideoByUserName(String username);

        Video findVideoByVideoId(Long videoId);

        List<Video> findVideoByTitle(String title);



    }


//    List<Video> findByTitleContainingOrContentContaining(String text, String textAgain);