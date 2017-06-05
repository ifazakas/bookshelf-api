package com.ifazakas.mybookshelfapi.infrastructure.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@SuppressWarnings("finalparameters")
public class JpaVolume {
  @Id
  private String id;
  private String author;
  private String title;
  private Integer publicationYear;

  public JpaVolume() {
  }

  public JpaVolume(final String id, final String author, final String title, final Integer publicationYear) {
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

  public Integer getPublicationYear() {
    return publicationYear;
  }
}
