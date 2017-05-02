package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.PublicationYearCannotBeInTheFutureException;
import com.ifazakas.mybookshelfapi.domain.exceptions.PublicationYearCannotBeNegativeException;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class PublicationYearTest {
  private static final int A_VALID_PUBPLICATION_YEAR = 1999;

  @Test
  public void shouldCreateAPublicationYear() throws Exception {
    PublicationYear aPublicationYear = new PublicationYear(A_VALID_PUBPLICATION_YEAR);

    assertThat(aPublicationYear.getValue()).isEqualTo(A_VALID_PUBPLICATION_YEAR);
  }

  @Test(expected = PublicationYearCannotBeNegativeException.class)
  public void shouldThrowPulicationYearCannotBeNegativeException() throws Exception {
    new PublicationYear(-1000);
  }

  @Test(expected = PublicationYearCannotBeInTheFutureException.class)
  public void shouldThrowPublicationYearCannotBeInTheFutureException() throws Exception {
    new PublicationYear(LocalDate.now().getYear() + 1);
  }
}