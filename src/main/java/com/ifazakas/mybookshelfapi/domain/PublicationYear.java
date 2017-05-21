package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.PublicationYearInTheFutureException;
import com.ifazakas.mybookshelfapi.domain.exceptions.PublicationYearNegativeException;

import java.time.LocalDate;

public class PublicationYear {
  private final int value;

  public PublicationYear(final int yearValue) {
    validate(yearValue);
    this.value = yearValue;
  }

  private void validate(final int yearValue) {
    if (yearValue < 0) {
      throw new PublicationYearNegativeException("Negative value given");
    }

    if (yearValue > LocalDate.now().getYear()) {
      throw new PublicationYearInTheFutureException("Given value is in the future");
    }
  }

  public int getValue() {
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

    PublicationYear that = (PublicationYear) o;

    return value == that.value;

  }

  @Override
  public int hashCode() {
    return value;
  }
}
