package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.ArgumentNullException;
import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameNotAlphabetic;
import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameTooLongException;
import com.ifazakas.mybookshelfapi.domain.exceptions.AuthorNameTooShortException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorTest {
  static final String A_VALID_AUTHOR_NAME = "William Shakespeare";

  @Test
  public void shouldCreateAnAuthorWithGivenName() throws Exception {
    Author anAuthor = new Author(A_VALID_AUTHOR_NAME);

    assertThat(anAuthor.getName()).isEqualTo(A_VALID_AUTHOR_NAME);
  }

  @Test(expected = ArgumentNullException.class)
  public void shouldThrowExceptionWhenAuthorNameIsNull() throws Exception {
    new Author(null);
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

  @Test
  public void shouldBeIdenticalToAnotherAuthorWithTheSameName() throws Exception {
    Author anAuthor = new Author(A_VALID_AUTHOR_NAME);
    Author anotherAuthor = new Author(A_VALID_AUTHOR_NAME);

    assertThat(anAuthor.equals(anotherAuthor)).isTrue();
    assertThat(anAuthor.hashCode()).isEqualTo(anotherAuthor.hashCode());

    assertThat(anAuthor.equals(new Author("Third author"))).isFalse();
  }

}
