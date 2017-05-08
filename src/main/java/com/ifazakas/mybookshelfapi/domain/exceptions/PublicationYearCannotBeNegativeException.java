package com.ifazakas.mybookshelfapi.domain.exceptions;

public class PublicationYearCannotBeNegativeException extends RuntimeException {
  public PublicationYearCannotBeNegativeException(final String message) {
    super(message);
  }
}
