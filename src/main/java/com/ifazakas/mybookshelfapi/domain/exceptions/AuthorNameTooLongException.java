package com.ifazakas.mybookshelfapi.domain.exceptions;

public class AuthorNameTooLongException extends RuntimeException {
  public AuthorNameTooLongException(String message) {
    super(message);
  }
}
