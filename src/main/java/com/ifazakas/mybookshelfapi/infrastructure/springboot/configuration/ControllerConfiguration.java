package com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration;

import com.ifazakas.mybookshelfapi.application.AddVolumeService;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.VolumesController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {
  @Bean
  public VolumesController volumesController(final AddVolumeService addVolumeService) {
    return new VolumesController(addVolumeService);
  }
}

