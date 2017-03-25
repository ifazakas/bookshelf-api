package com.ifazakas.mybookshelfapi.domain;

import java.util.UUID;

public class Book {
  private final String id;
  private final String author;
  private final String title;
  private final int publicationYear;

  public Book(final String author, final String title, final int publicationYear) {
    this.id = UUID.randomUUID().toString();
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
}
