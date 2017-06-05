package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.common.IntegrationTestBase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PingIntegrationTest extends IntegrationTestBase {

  @Test
  public void shouldPerformAPing() throws Exception {

    server()
        .perform(
            get("/ping")
                .accept(MEDIA_TYPE)
                .contentType(MEDIA_TYPE)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message", is("I'm here!")));
  }
}
