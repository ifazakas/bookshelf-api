package com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration;

import com.ifazakas.mybookshelfapi.domain.VolumeRepository;
import com.ifazakas.mybookshelfapi.infrastructure.jpa.JpaVolumeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

  @Bean
  VolumeRepository volumeRepository() {
    return new JpaVolumeRepository();
  }
}
