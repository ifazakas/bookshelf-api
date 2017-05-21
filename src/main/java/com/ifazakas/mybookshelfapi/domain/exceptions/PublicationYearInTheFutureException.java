package com.ifazakas.mybookshelfapi.domain.exceptions;

public class PublicationYearInTheFutureException extends RuntimeException {
  public PublicationYearInTheFutureException(final String message) {
    super(message);
  }
}
