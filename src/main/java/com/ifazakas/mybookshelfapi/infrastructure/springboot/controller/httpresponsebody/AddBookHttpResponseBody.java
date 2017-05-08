package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httpresponsebody;

import com.ifazakas.mybookshelfapi.domain.Volume;

public class AddBookHttpResponseBody {
  private final String id;
  private final String author;
  private final String title;
  private final int publicationYear;

  public AddBookHttpResponseBody(
      final String id,
      final String author,
      final String title,
      final int publicationYear
  ) {
    this.id = id;
    this.author = author;
    this.title = title;
    this.publicationYear = publicationYear;
  }

  public String getId() {
    return id;
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

  public static AddBookHttpResponseBody createFrom(final Volume volume) {
    return new AddBookHttpResponseBody(
        volume.getId(),
        volume.getAuthor().getName(),
        volume.getTitle().getValue(),
        volume.getPublicationYear().get().getValue()
    );
  }
}
