package com.ifazakas.mybookshelfapi.domain;

import com.ifazakas.mybookshelfapi.domain.exceptions.ArgumentMissingException;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class VolumeTest {
  private static final String AUTHOR_OF_REFACTORING = "Marting Fowler";
  private static final String TITLE_OF_REFACTORING = "Refactoring";
  private static final int PUBLICATION_YEAR_OF_REFACTORING = 1999;

  @Test
  public void shouldCreateAVolumeWithGivenValues() throws Exception {
    //given & when
    Volume aVolume = new Volume(
        new Author(AUTHOR_OF_REFACTORING),
        new Title(TITLE_OF_REFACTORING),
        new PublicationYear(PUBLICATION_YEAR_OF_REFACTORING)
    );

    //then
    assertThat(aVolume.getId()).isNotNull();
    assertThat(aVolume.getAuthor()).isEqualTo(new Author(AUTHOR_OF_REFACTORING));
    assertThat(aVolume.getTitle()).isEqualTo(new Title(TITLE_OF_REFACTORING));
    assertThat(aVolume.getPublicationYear().get()).isEqualTo(new PublicationYear(PUBLICATION_YEAR_OF_REFACTORING));

  }

  @Test(expected = ArgumentMissingException.class)
  public void shouldThrowExceptionWhenMissingAuthor() throws Exception {
    new Volume(
        null,
        new Title(TITLE_OF_REFACTORING),
        new PublicationYear(PUBLICATION_YEAR_OF_REFACTORING)
    );
  }

  @Test(expected = ArgumentMissingException.class)
  public void shouldThrowExceptionWhenMissingTitle() throws Exception {
    new Volume(
        new Author(AUTHOR_OF_REFACTORING),
        null,
        new PublicationYear(PUBLICATION_YEAR_OF_REFACTORING)
    );
  }

  @Test
  public void shouldCreateVolumeWithMissingPublicationYear() throws Exception {
    Volume aVolume = new Volume(
        new Author(AUTHOR_OF_REFACTORING),
        new Title(TITLE_OF_REFACTORING),
        null
    );

    assertThat(aVolume.getId()).isNotNull();
    assertThat(aVolume.getAuthor()).isEqualTo(new Author(AUTHOR_OF_REFACTORING));
    assertThat(aVolume.getTitle()).isEqualTo(new Title(TITLE_OF_REFACTORING));
    assertThat(aVolume.getPublicationYear()).isEqualTo(Optional.empty());
  }
}
