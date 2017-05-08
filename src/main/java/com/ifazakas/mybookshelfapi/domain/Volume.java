package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.ArgumentNullException;

import java.util.Optional;
import java.util.UUID;

public class Volume {
  private final String id;
  private final Author author;
  private final Title title;
  private final PublicationYear publicationYear;

  public Volume(final Author author, final Title title, final PublicationYear publicationYear) {
    validate(author, title);

    this.id = UUID.randomUUID().toString();
    this.author = author;
    this.title = title;
    this.publicationYear = publicationYear;
  }

  private void validate(final Author author, final Title title) {
    if (author == null) {
      throw new ArgumentNullException("Missing author");
    }
    if (title == null) {
      throw new ArgumentNullException("Missing title");
    }
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

  public Optional<PublicationYear> getPublicationYear() {
    return Optional.ofNullable(publicationYear);
  }
}
