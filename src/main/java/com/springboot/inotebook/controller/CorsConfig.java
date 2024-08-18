package com.springboot.inotebook.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Allow requests from any origin
                .allowedMethods("GET", "POST", "PATCH", "DELETE") // Specify the allowed HTTP methods
                .allowedHeaders("Content-Type", "Authorization") // Specify the allowed headers
                .exposedHeaders("*") // Specify any headers that should be exposed to the client
                .maxAge(3600); // Configure the max age of the CORS configuration
    }
}
