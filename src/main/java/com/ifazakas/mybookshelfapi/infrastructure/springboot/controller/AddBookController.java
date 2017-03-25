package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.application.AddBookService;
import com.ifazakas.mybookshelfapi.domain.Book;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httprequestbody.AddBookHttpRequestBody;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httpresponsebody.AddBookHttpResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class AddBookController {

  private final AddBookService addBookService;

  public AddBookController(final AddBookService addBookService) {
    this.addBookService = addBookService;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<AddBookHttpResponseBody> addBook(@RequestBody final AddBookHttpRequestBody httpRequestBody) {

    Book book = addBookService.addBook(
        httpRequestBody.getAuthor(),
        httpRequestBody.getTitle(),
        httpRequestBody.getPublicationYear()
    );

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(AddBookHttpResponseBody.createFrom(book));
  }

}
