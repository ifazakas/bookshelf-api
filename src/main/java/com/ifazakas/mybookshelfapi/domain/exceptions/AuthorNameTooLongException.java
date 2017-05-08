package com.ifazakas.mybookshelfapi.domain.exceptions;

public class AuthorNameTooLongException extends RuntimeException {
  public AuthorNameTooLongException(final String message) {
    super(message);
  }
}
