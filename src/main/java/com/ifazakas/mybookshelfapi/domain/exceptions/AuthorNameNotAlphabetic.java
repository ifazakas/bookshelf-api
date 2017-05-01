package com.ifazakas.mybookshelfapi.domain.exceptions;

public class AuthorNameNotAlphabetic extends RuntimeException {
  public AuthorNameNotAlphabetic(String message) {
    super(message);
  }
}
