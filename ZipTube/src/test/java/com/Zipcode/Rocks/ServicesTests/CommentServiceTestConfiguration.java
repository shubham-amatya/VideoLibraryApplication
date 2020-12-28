package com.Zipcode.Rocks.ServicesTests;

import com.Zipcode.Rocks.Services.CommentService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class CommentServiceTestConfiguration {
    @Bean
    @Primary
    public CommentService commentService() {
        return Mockito.mock(CommentService.class);
    }
}
