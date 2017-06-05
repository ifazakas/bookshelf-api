package com.ifazakas.mybookshelfapi.infrastructure.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
    "com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration",
    "com.ifazakas.mybookshelfapi.infrastructure.springboot.controller"
})
@EnableJpaRepositories("com.ifazakas.mybookshelfapi.infrastructure.jpa")
@EntityScan("com.ifazakas.mybookshelfapi.infrastructure.jpa")
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class Application {

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
