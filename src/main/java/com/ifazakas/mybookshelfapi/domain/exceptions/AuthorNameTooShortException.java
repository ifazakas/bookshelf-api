package com.ifazakas.mybookshelfapi.domain.exceptions;

public class AuthorNameTooShortException extends RuntimeException {
  public AuthorNameTooShortException(String message) {
    super(message);
  }
}
