package com.cherniaev.agileengine.photosearcher.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
        "com.cherniaev.agileengine.photosearcher.controller",
        "com.cherniaev.agileengine.photosearcher.service",
        "com.cherniaev.agileengine.photosearcher.configuration",
})
@EnableJpaRepositories(basePackages="com.cherniaev.agileengine.photosearcher.repository")
@EntityScan(basePackages="com.cherniaev.agileengine.photosearcher.entity")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
