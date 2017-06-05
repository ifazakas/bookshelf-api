package com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration;


import com.ifazakas.mybookshelfapi.application.AddVolumeService;
import com.ifazakas.mybookshelfapi.domain.VolumeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
  @Bean
  public AddVolumeService addBookService(final VolumeRepository volumeRepository) {
    return new AddVolumeService(volumeRepository);
  }
}
