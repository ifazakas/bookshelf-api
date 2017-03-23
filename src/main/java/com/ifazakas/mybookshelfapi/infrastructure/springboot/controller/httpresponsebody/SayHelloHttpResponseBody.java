package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httpresponsebody;

public class SayHelloHttpResponseBody {
    private final String message;

    public SayHelloHttpResponseBody(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
