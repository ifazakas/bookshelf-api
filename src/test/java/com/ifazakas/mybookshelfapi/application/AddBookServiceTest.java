package com.ifazakas.mybookshelfapi.application;

import com.ifazakas.mybookshelfapi.domain.Book;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddBookServiceTest {
  private AddBookService addBookService;

  @Before
  public void setUp() throws Exception {
    addBookService = new AddBookService();
  }

  @Test
  @SuppressWarnings("checkstyle:magicnumber")
  public void shouldAddABook() throws Exception {
    //when
    Book actualBook = addBookService.addBook("Martin Fowler", "Refactoring", 1999);

    //then
    assertThat(actualBook).isNotNull();

  }
}
