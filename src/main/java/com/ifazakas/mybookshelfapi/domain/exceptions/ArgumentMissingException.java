package com.ifazakas.mybookshelfapi.domain.exceptions;

public class ArgumentMissingException extends RuntimeException {
  public ArgumentMissingException(final String message) {
    super(message);
  }
}
