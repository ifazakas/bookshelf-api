package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.common;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.nio.charset.Charset;
import java.util.Scanner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest
public abstract class ControllerTestBase {
  protected static final MediaType MEDIA_TYPE = MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE);
  @Autowired
  private MockMvc server;

  protected MockMvc server() {
    return server;
  }

  protected String getResourceAsString(String resource) {
    Scanner scanner = new Scanner(
        getClass().getClassLoader().getResourceAsStream(resource),
        Charset.forName("UTF-8").toString()
    ).useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
  }

  protected MockHttpServletRequestBuilder createPostRequest(String endpoint, String body) {
    return post(endpoint)
        .accept(MEDIA_TYPE)
        .contentType(MEDIA_TYPE)
        .content(body);
  }
}
