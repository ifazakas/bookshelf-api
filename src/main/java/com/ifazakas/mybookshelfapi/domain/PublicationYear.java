package com.ifazakas.mybookshelfapi.domain;

public class PublicationYear {
  private final int value;

  public PublicationYear(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PublicationYear that = (PublicationYear) o;

    return value == that.value;

  }

  @Override
  public int hashCode() {
    return value;
  }
}
