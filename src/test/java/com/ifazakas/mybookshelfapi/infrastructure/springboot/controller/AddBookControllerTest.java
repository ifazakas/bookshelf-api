package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.common.ControllerTestBase;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AddBookControllerTest extends ControllerTestBase {
  private static final String BOOKS_ENDPOINT = "/books";

  @Test
  @SuppressWarnings("checkstyle:magicnumber")
  public void shouldAddABook() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        BOOKS_ENDPOINT,
        getResourceAsString("addbook/request-body-for-201-created.json")
    );
    server()
        .perform(request)
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", isA(String.class)))
        .andExpect(jsonPath("$.author", is("Martin Fowler")))
        .andExpect(jsonPath("$.title", is("Refactoring")))
        .andExpect(jsonPath("$.publication_year", is(1999)));
  }
}
