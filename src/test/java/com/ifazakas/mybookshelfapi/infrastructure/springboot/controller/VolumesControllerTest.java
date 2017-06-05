package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.common.ControllerTestBase;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VolumesControllerTest extends ControllerTestBase {
  private static final String VOLUMES_ENDPOINT = "/volumes";

  @Test
  @SuppressWarnings("checkstyle:magicnumber")
  public void shouldAddAVolume() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        VOLUMES_ENDPOINT,
        getResourceAsString("httprequestbody/addvolume/201-created.json")
    );
    server()
        .perform(request)
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id", isA(String.class)))
        .andExpect(jsonPath("$.author", is("Martin Fowler")))
        .andExpect(jsonPath("$.title", is("Refactoring")))
        .andExpect(jsonPath("$.publication_year", is(1999)));
  }

  @Test
  public void badRequestWhenAuthorNameNotAlphabetic() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        VOLUMES_ENDPOINT,
        getResourceAsString("httprequestbody/addvolume/400-author-name-not-alphabetic.json")
    );
    server()
        .perform(request)
        .andExpect(status().isBadRequest());
  }

  @Test
  public void badRequestWhenAuthorNameTooLong() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        VOLUMES_ENDPOINT,
        getResourceAsString("httprequestbody/addvolume/400-author-name-too-long.json")
    );
    server()
        .perform(request)
        .andExpect(status().isBadRequest());
  }

  @Test
  public void badRequestWhenAuthorNameTooShort() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        VOLUMES_ENDPOINT,
        getResourceAsString("httprequestbody/addvolume/400-author-name-too-short.json")
    );
    server()
        .perform(request)
        .andExpect(status().isBadRequest());
  }

  @Test
  public void badRequestWhenPublicationYearInTheFuture() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        VOLUMES_ENDPOINT,
        getResourceAsString("httprequestbody/addvolume/400-publication-year-in-the-future.json")
    );
    server()
        .perform(request)
        .andExpect(status().isBadRequest());
  }

  @Test
  public void badRequestWhenPublicationYearNegative() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        VOLUMES_ENDPOINT,
        getResourceAsString("httprequestbody/addvolume/400-publication-year-negative.json")
    );
    server()
        .perform(request)
        .andExpect(status().isBadRequest());
  }

  @Test
  public void badRequestWhenTitleNotAlphanumeric() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        VOLUMES_ENDPOINT,
        getResourceAsString("httprequestbody/addvolume/400-title-not-alphanumeric.json")
    );
    server()
        .perform(request)
        .andExpect(status().isBadRequest());
  }

  @Test
  public void badRequestWhenTitleTooLong() throws Exception {
    MockHttpServletRequestBuilder request = createPostRequest(
        VOLUMES_ENDPOINT,
        getResourceAsString("httprequestbody/addvolume/400-title-too-long.json")
    );
    server()
        .perform(request)
        .andExpect(status().isBadRequest());
  }
}
