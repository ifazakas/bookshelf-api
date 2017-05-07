package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httpresponsebody;

public class PingHttpResponseBody {
  private final String message;

  public PingHttpResponseBody(final String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
