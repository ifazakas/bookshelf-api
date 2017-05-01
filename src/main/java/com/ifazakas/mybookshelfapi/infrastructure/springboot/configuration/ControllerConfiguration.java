package com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration;

import com.ifazakas.mybookshelfapi.application.AddVolumeService;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.AddBookController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {
  @Bean
  public AddBookController addBookController(final AddVolumeService addVolumeService) {
    return new AddBookController(addVolumeService);
  }
}

