package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.ArgumentNullException;
import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameNotAlphabetic;
import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameTooLongException;
import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameTooShortException;

public class Author {
  private static final int MIN_NAME_LENGTH = 5;
  private static final int MAX_NAME_LENGTH = 50;
  private final String name;

  public Author(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if (name == null) {
      throw new ArgumentNullException("Author name must have a value");
    }

    if (name.length() > MAX_NAME_LENGTH) {
      throw new AuthorNameTooLongException("Length cannot exceed " + MAX_NAME_LENGTH + " characters");
    }
    if (name.length() < MIN_NAME_LENGTH) {
      throw new AuthorNameTooShortException("Length cannot be less than " + MIN_NAME_LENGTH + " characters");

    }
    if (!containsOnlyLettersAndSpace(name)) {
      throw new AuthorNameNotAlphabetic("Author name should contain only letters and space");
    }
  }

  private boolean containsOnlyLettersAndSpace(String name) {
    return name.chars().allMatch(this::isLetterOrSpace);
  }

  private boolean isLetterOrSpace(int aChar) {
    return Character.isLetter(aChar) || Character.isSpaceChar(aChar);
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Author author = (Author) o;

    return name != null ? name.equals(author.name) : author.name == null;

  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
