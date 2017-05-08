package com.ifazakas.mybookshelfapi.domain.exceptions;

public class AuthorNameTooShortException extends RuntimeException {
  public AuthorNameTooShortException(final String message) {
    super(message);
  }
}
