package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.common;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public abstract class ControllerTestBase {
  protected static final MediaType MEDIA_TYPE = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
  @Autowired
  private MockMvc server;

  protected MockMvc server() {
    return server;
  }

}
