package com.ifazakas.mybookshelfapi.domain.exceptions;

public class AuthorNameNotAlphabetic extends RuntimeException {
  public AuthorNameNotAlphabetic(final String message) {
    super(message);
  }
}
