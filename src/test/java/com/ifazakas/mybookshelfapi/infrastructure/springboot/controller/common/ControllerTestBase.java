package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.common;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ControllerTestBase {
  protected static final MediaType MEDIA_TYPE = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
  @Autowired
  private WebApplicationContext context;
  private MockMvc server;

  @Before
  public void setup() {
    server = MockMvcBuilders
        .webAppContextSetup(context)
        .build();
  }

  protected MockMvc server() {
    return server;
  }

}