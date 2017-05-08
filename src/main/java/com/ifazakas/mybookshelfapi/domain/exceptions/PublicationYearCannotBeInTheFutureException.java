package com.ifazakas.mybookshelfapi.domain.exceptions;

public class PublicationYearCannotBeInTheFutureException extends RuntimeException {
  public PublicationYearCannotBeInTheFutureException(final String message) {
    super(message);
  }
}
