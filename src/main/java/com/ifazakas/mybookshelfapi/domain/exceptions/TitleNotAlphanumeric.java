package com.ifazakas.mybookshelfapi.domain.exceptions;

public class TitleNotAlphanumeric extends RuntimeException {
  public TitleNotAlphanumeric(String message) {
    super(message);
  }
}
