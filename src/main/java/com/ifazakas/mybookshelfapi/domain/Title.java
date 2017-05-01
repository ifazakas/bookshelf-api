package com.ifazakas.mybookshelfapi.domain;

public class Title {
  private final String value;

  public Title(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Title title = (Title) o;

    return value != null ? value.equals(title.value) : title.value == null;

  }

  @Override
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
