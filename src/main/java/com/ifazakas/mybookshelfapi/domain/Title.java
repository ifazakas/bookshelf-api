package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.ArgumentNullException;
import com.ifazakas.mybookshelfapi.domain.exceptions.TitleNotAlphanumeric;
import com.ifazakas.mybookshelfapi.domain.exceptions.TitleTooLongException;

public class Title {
  private static final int MAX_TITLE_LENGTH = 150;

  private final String value;

  public Title(final String titleValue) {
    validate(titleValue);
    this.value = titleValue;
  }

  private void validate(final String titleValue) {
    if (titleValue == null) {
      throw new ArgumentNullException("Title must have a value");
    }

    if (titleValue.length() > MAX_TITLE_LENGTH) {
      throw new TitleTooLongException("Title cannot exceed " + MAX_TITLE_LENGTH + "characters");
    }
    if (!containsOnlyLettersDigitsOrSpace(titleValue)) {
      throw new TitleNotAlphanumeric("Title name should contain only letters, digits or space");
    }
  }

  private boolean containsOnlyLettersDigitsOrSpace(final String titleValue) {
    return titleValue.chars().allMatch(this::isLetterDigitOrSpace);
  }

  private boolean isLetterDigitOrSpace(final int aChar) {
    return Character.isLetterOrDigit(aChar) || Character.isSpaceChar(aChar);
  }

  public String getValue() {
    return value;
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

    Title title = (Title) o;

    return value != null ? value.equals(title.value) : title.value == null;

  }

  @Override
  @SuppressWarnings("checkstyle:avoidinlineconditionals")
  public int hashCode() {
    return value != null ? value.hashCode() : 0;
  }
}
