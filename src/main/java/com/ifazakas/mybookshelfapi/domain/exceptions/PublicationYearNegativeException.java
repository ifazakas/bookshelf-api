package com.ifazakas.mybookshelfapi.domain.exceptions;

public class PublicationYearNegativeException extends RuntimeException {
  public PublicationYearNegativeException(final String message) {
    super(message);
  }
}
