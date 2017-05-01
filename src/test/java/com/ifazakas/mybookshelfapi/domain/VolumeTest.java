package com.ifazakas.mybookshelfapi.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VolumeTest {

  @Test
  public void shouldCreateAVolumeWithGivenValues() throws Exception {
    //given & when
    Volume aVolume = new Volume(
        new Author("Martin Fowler"),
        new Title("Refactoring"),
        new PublicationYear(1999)
    );

    //then
    assertThat(aVolume.getId()).isNotNull();
    assertThat(aVolume.getAuthor()).isEqualTo(new Author("Martin Fowler"));
    assertThat(aVolume.getTitle()).isEqualTo(new Title("Refactoring"));
    assertThat(aVolume.getPublicationYear()).isEqualTo(new PublicationYear(1999));

  }
}