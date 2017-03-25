package com.ifazakas.mybookshelfapi.infrastructure.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
    "com.ifazakas.mybookshelfapi.infrastructure.springboot.configuration",
    "com.ifazakas.mybookshelfapi.infrastructure.springboot.controller"
})
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class Application {

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
