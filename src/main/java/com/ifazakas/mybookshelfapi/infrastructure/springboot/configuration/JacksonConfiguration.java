package com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfiguration {

  @Autowired
  public void configureJackson(final ObjectMapper jackson2ObjectMapper) {
    jackson2ObjectMapper
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

  }
}
