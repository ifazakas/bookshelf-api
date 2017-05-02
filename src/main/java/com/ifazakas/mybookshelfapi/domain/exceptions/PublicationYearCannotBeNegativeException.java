package com.ifazakas.mybookshelfapi.domain.exceptions;

public class PublicationYearCannotBeNegativeException extends RuntimeException {
  public PublicationYearCannotBeNegativeException(String message) {
    super(message);
  }
}
