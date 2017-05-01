package com.ifazakas.mybookshelfapi.domain;

import java.util.UUID;

public class Volume {
  private final String id;
  private final Author author;
  private final Title title;
  private final PublicationYear publicationYear;

  public Volume(final Author author, final Title title, final PublicationYear publicationYear) {
    this.id = UUID.randomUUID().toString();
    this.author = author;
    this.title = title;
    this.publicationYear = publicationYear;
  }

  public String getId() {
    return id;
  }

  public Author getAuthor() {
    return author;
  }

  public Title getTitle() {
    return title;
  }

  public PublicationYear getPublicationYear() {
    return publicationYear;
  }
}
