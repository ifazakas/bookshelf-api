package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httprequestbody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddVolumeHttpRequestBody {
  private final String author;
  private final String title;
  private final int publicationYear;

  public AddVolumeHttpRequestBody(
      @JsonProperty(value = "author", required = true) final String author,
      @JsonProperty(value = "title", required = true) final String title,
      @JsonProperty(value = "publication_year", required = true) final int publicationYear
  ) {
    this.author = author;
    this.title = title;
    this.publicationYear = publicationYear;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public int getPublicationYear() {
    return publicationYear;
  }
}
