package com.cherniaev.agileengine.photosearcher.configuration;

import com.cherniaev.agileengine.photosearcher.service.AgileEnginePhotoServiceImpl;
import com.cherniaev.agileengine.photosearcher.service.PhotoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PhotoService photoService() {
        return new AgileEnginePhotoServiceImpl();
    }

}
