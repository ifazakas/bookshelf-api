package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.PublicationYearInTheFutureException;
import com.ifazakas.mybookshelfapi.domain.exceptions.PublicationYearNegativeException;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class PublicationYearTest {
  private static final int A_VALID_PUBLICATION_YEAR = 1999;
  private static final int ANOTHER_VALID_PUBLICATION_YEAR = 2000;
  private static final int NEGATIVE_VALUED_PUBLICATION_YEAR = -1000;

  @Test
  public void shouldCreateAPublicationYear() throws Exception {
    PublicationYear aPublicationYear = new PublicationYear(A_VALID_PUBLICATION_YEAR);

    assertThat(aPublicationYear.getValue()).isEqualTo(A_VALID_PUBLICATION_YEAR);
  }

  @Test(expected = PublicationYearNegativeException.class)
  public void shouldThrowPulicationYearCannotBeNegativeException() throws Exception {
    new PublicationYear(NEGATIVE_VALUED_PUBLICATION_YEAR);
  }

  @Test(expected = PublicationYearInTheFutureException.class)
  public void shouldThrowPublicationYearCannotBeInTheFutureException() throws Exception {
    new PublicationYear(LocalDate.now().getYear() + 1);
  }

  @Test
  public void shouldBeIdenticalToAnotherPublicationYearWithTheSameValue() throws Exception {
    PublicationYear aPublicationYear = new PublicationYear(A_VALID_PUBLICATION_YEAR);
    PublicationYear anotherPublicationYear = new PublicationYear(A_VALID_PUBLICATION_YEAR);

    assertThat(aPublicationYear.equals(anotherPublicationYear)).isTrue();
    assertThat(aPublicationYear.hashCode()).isEqualTo(anotherPublicationYear.hashCode());

    assertThat(aPublicationYear.equals(new PublicationYear(ANOTHER_VALID_PUBLICATION_YEAR))).isFalse();
  }
}
