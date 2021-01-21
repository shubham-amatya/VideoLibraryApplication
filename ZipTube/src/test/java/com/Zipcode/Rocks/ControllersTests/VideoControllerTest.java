package com.Zipcode.Rocks.ControllersTests;

import com.Zipcode.Rocks.Models.Video;
import com.Zipcode.Rocks.Services.VideoService;
import com.Zipcode.Rocks.ZipTubeApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZipTubeApplication.class)
@AutoConfigureMockMvc //(, secretKey)
@TestPropertySource(locations = {"classpath:application.properties"})

public class VideoControllerTest {

    @Autowired
    private MockMvc mvc;


    @MockBean
    private VideoService service;

    ObjectMapper objectMapper = new ObjectMapper();

    Video video1;
    Video video2;
    Video video3;
    List<Video> videos;

    @Value("${aws.endpointUrl}")
    private String endpointUrl;
    @Value("${aws.bucket}")
    private String bucketName;
    @Value("${aws.access_key_id}")
    private String accessKey;
    @Value("${aws.secret_access_key}")
    private String secretKey;
    @Value("${spring.datasource.url}")
    private String DATASOURCE_URL;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("S{spring.datasource.password}")
    private String password;

    @Before
    public void setup() {

        video1 = new Video("Terrible testing practices", "https://random.com", "how not to do Mockito testing", "shu");
        video2 = new Video("Cats", "https://randomcat.com", "Toby chasing Booboo", "Chris");
        video3 = new Video("Travel vlog", "https://random.com", "Malaysia tour", "Dino");
        videos = new ArrayList<>();
        videos.add(video1);
        videos.add(video2);
        videos.add(video3);
    }

    @Test
    public void getAllVideoByUserName() throws Exception {

        Mockito.when(service.getAllVideosByUserName("shu")).thenReturn(videos);
        mvc.perform(get("//video/allvideos"))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void testAddVideo() {
        try {
            String jsonRequest = objectMapper.writeValueAsString(video1);
            Mockito.when(service.addVideo(any())).thenReturn(video1);
            mvc.perform(post("/comment/addcomment")
                    .content(jsonRequest)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.comment", is("Wow nice!")))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteVideo() throws Exception {
        try {
            String jsonRequest = objectMapper.writeValueAsString(video1);

//            Mockito.when(service.deleteVideo(123L)).thenReturn();
//            mvc.perform(delete("/deletevideo/{videoId}"))
//                    .andExpect(status().isForbidden());
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllVideoByTitle() throws Exception {

        Mockito.when(service.getAllVideosByUserName("Cats")).thenReturn(videos);
        mvc.perform(get("/videobytitle/{title}"))
                .andExpect(status().isOk())
                .andReturn();
    }


    @Test
    public void testUpdateVideo() {
        try {
            String jsonRequest = objectMapper.writeValueAsString(video1);
            //   Mockito.when(service.updateVideoByVideoId((123L))).thenReturn(video1);
            mvc.perform(post("")
                    .content(jsonRequest)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.comment", is("Wow nice!")))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
