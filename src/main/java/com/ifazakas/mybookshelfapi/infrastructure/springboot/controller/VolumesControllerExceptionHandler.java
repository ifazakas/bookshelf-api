package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.domain.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

interface VolumesControllerExceptionHandler {
  Logger LOGGER = LoggerFactory.getLogger(VolumesControllerExceptionHandler.class);

  @ExceptionHandler(AuthorNameNotAlphabetic.class)
  default void authorNameNotAlphabeticException(
      AuthorNameNotAlphabetic exception, HttpServletRequest request, HttpServletResponse response
  ) throws IOException {
    LOGGER.error(exception.getMessage());
    response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler(AuthorNameTooLongException.class)
  default void authorNameTooLongException(
      AuthorNameTooLongException exception, HttpServletRequest request, HttpServletResponse response
  ) throws IOException {
    LOGGER.error(exception.getMessage());
    response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler(AuthorNameTooShortException.class)
  default void authorNameTooShortException(
      AuthorNameTooShortException exception, HttpServletRequest request, HttpServletResponse response
  ) throws IOException {
    LOGGER.error(exception.getMessage());
    response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler(PublicationYearNegativeException.class)
  default void publicationYearNegativeException(
      PublicationYearNegativeException exception, HttpServletRequest request, HttpServletResponse response
  ) throws IOException {
    LOGGER.error(exception.getMessage());
    response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler(PublicationYearInTheFutureException.class)
  default void publicationYearInTheFutureException(
      PublicationYearInTheFutureException exception, HttpServletRequest request, HttpServletResponse response
  ) throws IOException {
    LOGGER.error(exception.getMessage());
    response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler(TitleNotAlphanumeric.class)
  default void titleNotAlphanumeric(
      TitleNotAlphanumeric exception, HttpServletRequest request, HttpServletResponse response
  ) throws IOException {
    LOGGER.error(exception.getMessage());
    response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }

  @ExceptionHandler(TitleTooLongException.class)
  default void titleTooLongException(
      TitleTooLongException exception, HttpServletRequest request, HttpServletResponse response
  ) throws IOException {
    LOGGER.error(exception.getMessage());
    response.sendError(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
  }
}
