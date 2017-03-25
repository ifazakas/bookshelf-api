package com.ifazakas.mybookshelfapi.application;

import com.ifazakas.mybookshelfapi.domain.Book;

public class AddBookService {
  public Book addBook(
      final String author,
      final String title,
      final int publicationYear
  ) {
    return new Book(
        author,
        title,
        publicationYear
    );
  }
}
