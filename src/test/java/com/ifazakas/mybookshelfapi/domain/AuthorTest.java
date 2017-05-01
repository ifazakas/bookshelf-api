package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameNotAlphabetic;
import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameTooLongException;
import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameTooShortException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorTest {
  @Test
  public void shouldCreateAnAuthorWithGivenName() throws Exception {
    Author anAuthor = new Author("William Shakespeare");

    assertThat(anAuthor.getName()).isEqualTo("William Shakespeare");
  }

  @Test(expected = AuthorNameTooLongException.class)
  public void shouldThrowAuthorNameTooLongException() throws Exception {
    new Author("William Shakespeare William Shakespeare William Shakespeare");
  }

  @Test(expected = AuthorNameTooShortException.class)
  public void shouldThrowAuthorNameTooShortException() throws Exception {
    new Author("Wil");
  }

  @Test(expected = AuthorNameNotAlphabetic.class)
  public void shouldSupportOnlyLettersAndSpaceCharactersInName() throws Exception {
    new Author("Wil1111");

  }
}
