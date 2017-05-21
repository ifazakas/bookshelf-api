package com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration;

import com.ifazakas.mybookshelfapi.application.AddVolumeService;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.AddVolumeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {
  @Bean
  public AddVolumeController addBookController(final AddVolumeService addVolumeService) {
    return new AddVolumeController(addVolumeService);
  }
}

