package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.ArgumentNullException;
import com.ifazakas.mybookshelfapi.domain.exceptions.TitleNotAlphanumeric;
import com.ifazakas.mybookshelfapi.domain.exceptions.TitleTooLongException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TitleTest {
  private static final String A_VALID_TITLE = "To Kill a Mockingbird";

  @Test
  public void shouldCreateATitle() throws Exception {
    Title aTitle = new Title(A_VALID_TITLE);

    assertThat(aTitle.getValue()).isEqualTo(A_VALID_TITLE);
  }

  @Test(expected = ArgumentNullException.class)
  public void shouldThrowExceptionWhenTitleValueIsNull() throws Exception {
    new Title(null);
  }

  @Test(expected = TitleTooLongException.class)
  public void shouldThrowTitleTooLongException() throws Exception {
    new Title(
        "To Kill a Mockingbird To Kill a Mockingbird To Kill a Mockingbird"
        + "To Kill a Mockingbird To Kill a Mockingbird To Kill a Mockingbird"
        + "To Kill a Mockingbird To Kill a Mockingbird To Kill a Mockingbird"
    );
  }

  @Test(expected = TitleNotAlphanumeric.class)
  public void shouldThrowExceptionWhenTitleNotAlphanumericOrSpace() throws Exception {
    new Title("|");
  }

  @Test
  public void shouldBeIdenticalToAnotherTitleWithTheSameValue() throws Exception {
    Title aTitle = new Title(A_VALID_TITLE);
    Title anotherTitle = new Title(A_VALID_TITLE);

    assertThat(aTitle.equals(anotherTitle)).isTrue();
    assertThat(aTitle.hashCode()).isEqualTo(anotherTitle.hashCode());

    assertThat(aTitle.equals(new Title("Third title"))).isFalse();

  }
}
