package com.ifazakas.mybookshelfapi.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VolumeTest {
  private static final int RECATORING_PUBLICATION_YEAR = 1999;

  @Test
  public void shouldCreateAVolumeWithGivenValues() throws Exception {
    //given & when
    Volume aVolume = new Volume(
        new Author("Martin Fowler"),
        new Title("Refactoring"),
        new PublicationYear(RECATORING_PUBLICATION_YEAR)
    );

    //then
    assertThat(aVolume.getId()).isNotNull();
    assertThat(aVolume.getAuthor()).isEqualTo(new Author("Martin Fowler"));
    assertThat(aVolume.getTitle()).isEqualTo(new Title("Refactoring"));
    assertThat(aVolume.getPublicationYear()).isEqualTo(new PublicationYear(RECATORING_PUBLICATION_YEAR));

  }
}
