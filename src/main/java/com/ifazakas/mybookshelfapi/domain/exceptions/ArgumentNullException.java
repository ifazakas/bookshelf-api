package com.ifazakas.mybookshelfapi.domain.exceptions;

public class ArgumentNullException extends RuntimeException {
  public ArgumentNullException(String message) {
    super(message);
  }
}
