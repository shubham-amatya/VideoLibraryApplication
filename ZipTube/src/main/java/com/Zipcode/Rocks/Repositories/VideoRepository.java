package com.Zipcode.Rocks.Repositories;

import com.Zipcode.Rocks.Models.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long>{


        Video findVideoByUserName(String username);

        Video findVideoByVideoId(Long videoId);

        List<Video> findVideoByTitle(String title);
    }

