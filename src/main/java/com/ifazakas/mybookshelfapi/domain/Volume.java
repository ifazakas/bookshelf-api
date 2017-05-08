package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.ArgumentNullException;

import java.util.Optional;

public class Volume {
  private final VolumeId id;
  private final Author author;
  private final Title title;
  private final PublicationYear publicationYear;

  public Volume(final Author author, final Title title, final PublicationYear publicationYear) {
    validate(author, title);

    this.id = VolumeId.createId();
    this.author = author;
    this.title = title;
    this.publicationYear = publicationYear;
  }

  private void validate(final Author authorValue, final Title titleValue) {
    if (authorValue == null) {
      throw new ArgumentNullException("Missing author");
    }
    if (titleValue == null) {
      throw new ArgumentNullException("Missing title");
    }
  }

  public VolumeId getId() {
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

  @Override
  @SuppressWarnings("checkstyle:avoidinlineconditionals")
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Volume volume = (Volume) o;

    return id != null ? id.equals(volume.id) : volume.id == null;

  }

  @Override
  @SuppressWarnings("checkstyle:avoidinlineconditionals")
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
