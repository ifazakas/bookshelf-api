package com.ifazakas.mybookshelfapi.domain.exceptions;

public class PublicationYearCannotBeInTheFutureException extends RuntimeException {
  public PublicationYearCannotBeInTheFutureException(String message) {
    super(message);
  }
}
