package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.TitleNotAlphanumeric;
import com.ifazakas.mybookshelfapi.domain.exceptions.TitleTooLongException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TitleTest {
  private static final String A_TITLE_VALUE = "To Kill a Mockingbird";

  @Test
  public void shouldCreateATitle() throws Exception {
    Title aTitle = new Title(A_TITLE_VALUE);

    assertThat(aTitle.getValue()).isEqualTo(A_TITLE_VALUE);
  }

  @Test(expected = TitleTooLongException.class)
  public void shouldThrowTitleTooLongException() throws Exception {
    new Title(
        "To Kill a Mockingbird To Kill a Mockingbird To Kill a Mockingbird" +
        "To Kill a Mockingbird To Kill a Mockingbird To Kill a Mockingbird" +
        "To Kill a Mockingbird To Kill a Mockingbird To Kill a Mockingbird"
    );
  }

  @Test(expected = TitleNotAlphanumeric.class)
  public void shouldThrowExceptionWhenTitleNotAlphanumericOrSpace() throws Exception {
    new Title("|");
  }
}