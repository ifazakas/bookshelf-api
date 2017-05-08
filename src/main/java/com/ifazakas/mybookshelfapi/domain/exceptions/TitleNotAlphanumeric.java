package com.ifazakas.mybookshelfapi.domain.exceptions;

public class TitleNotAlphanumeric extends RuntimeException {
  public TitleNotAlphanumeric(final String message) {
    super(message);
  }
}
