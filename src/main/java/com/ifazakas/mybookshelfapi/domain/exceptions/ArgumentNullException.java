package com.ifazakas.mybookshelfapi.domain.exceptions;

public class ArgumentNullException extends RuntimeException {
  public ArgumentNullException(final String message) {
    super(message);
  }
}
