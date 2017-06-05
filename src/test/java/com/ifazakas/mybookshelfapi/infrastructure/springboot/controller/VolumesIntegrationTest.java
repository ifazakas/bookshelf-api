package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.common.IntegrationTestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VolumesIntegrationTest extends IntegrationTestBase {
  private static final String VOLUMES_ENDPOINT = "/volumes";
  private static final String AUTHOR_OF_REFACTORING = "Martin Fowler";
  private static final String TITLE_OF_REFACTORING = "Refactoring";
  private static final int PUBLICATION_YEAR_OF_REFACTORING = 1999;
  @Autowired
  private JdbcTemplate jdbcTemplate;

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
        .andExpect(jsonPath("$.author", is(AUTHOR_OF_REFACTORING)))
        .andExpect(jsonPath("$.title", is(TITLE_OF_REFACTORING)))
        .andExpect(jsonPath("$.publication_year", is(PUBLICATION_YEAR_OF_REFACTORING)));

    Map<String, Object> persistedVolume = findAll().get(0);
    assertThat(persistedVolume.get("author")).isEqualTo(AUTHOR_OF_REFACTORING);
    assertThat(persistedVolume.get("title")).isEqualTo(TITLE_OF_REFACTORING);
    assertThat(persistedVolume.get("publication_year")).isEqualTo(PUBLICATION_YEAR_OF_REFACTORING);
  }

  public List<Map<String, Object>> findAll() {
    String query =
        "SELECT id, author, publication_year, title "
            + "FROM jpa_volume ";

    return jdbcTemplate.queryForList(query);
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
