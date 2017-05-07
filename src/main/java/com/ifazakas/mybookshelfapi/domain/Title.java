package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.ArgumentNullException;
import com.ifazakas.mybookshelfapi.domain.exceptions.TitleNotAlphanumeric;
import com.ifazakas.mybookshelfapi.domain.exceptions.TitleTooLongException;

public class Title {
  private static final int MAX_TITLE_LENGTH = 150;

  private final String value;

  public Title(String value) {
    validate(value);
    this.value = value;
  }

  private void validate(String value) {
    if (value == null) {
      throw new ArgumentNullException("Title must have a value");
    }

    if (value.length() > MAX_TITLE_LENGTH) {
      throw new TitleTooLongException("Title cannot exceed " + MAX_TITLE_LENGTH + "characters");
    }
    if (!containsOnlyLettersDigitsOrSpace(value)) {
      throw new TitleNotAlphanumeric("Title name should contain only letters, digits or space");
    }
  }

  private boolean containsOnlyLettersDigitsOrSpace(String value) {
    return value.chars().allMatch(this::isLetterDigitOrSpace);
  }

  private boolean isLetterDigitOrSpace(int aChar) {
    return Character.isLetterOrDigit(aChar) || Character.isSpaceChar(aChar) ;
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
