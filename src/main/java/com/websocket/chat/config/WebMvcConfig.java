package com.websocket.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedOrigins("http://localhost:3000")
                .allowedOrigins("https://localhost:8080")
                .allowedOrigins("http://localhost:8080")
                .allowedOrigins("https://chinda.live")
                .allowedOrigins("https://www.chinda.live")
                .allowedOrigins("https://www.epikoding.shop")
                .allowedOrigins("https://epikoding.shop")
                .allowedMethods("POST", "GET", "PUT", "DELETE", "HEAD", "OPTIONS", "UPGRADE")
                .allowCredentials(true)
                .exposedHeaders("Authorization");
    }
}