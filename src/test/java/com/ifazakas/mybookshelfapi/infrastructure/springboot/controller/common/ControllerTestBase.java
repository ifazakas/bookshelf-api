package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.common;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;
import java.util.Scanner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class ControllerTestBase {

  protected static final MediaType MEDIA_TYPE = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
  private MockMvc server;
  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setUp() throws Exception {
    server = webAppContextSetup(webApplicationContext)
        .build();
  }

  protected MockMvc server() {
    return server;
  }

  @SuppressWarnings("checkstyle:avoidinlineconditionals")
  protected String getResourceAsString(final String resource) {
    Scanner scanner = new Scanner(
        getClass().getClassLoader().getResourceAsStream(resource),
        Charset.forName("UTF-8").toString()
    ).useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
  }

  protected MockHttpServletRequestBuilder createPostRequest(final String endpoint, final String body) {
    return post(endpoint)
        .accept(MEDIA_TYPE)
        .contentType(MEDIA_TYPE)
        .content(body);
  }
}
