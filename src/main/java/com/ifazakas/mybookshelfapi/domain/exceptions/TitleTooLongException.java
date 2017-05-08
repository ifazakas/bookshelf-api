package com.ifazakas.mybookshelfapi.domain.exceptions;

public class TitleTooLongException extends RuntimeException {
  public TitleTooLongException(final String message) {
    super(message);
  }
}
