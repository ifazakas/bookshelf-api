package com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration;


import com.ifazakas.mybookshelfapi.application.AddBookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {
  @Bean
  public AddBookService addBookService() {
    return new AddBookService();
  }
}
