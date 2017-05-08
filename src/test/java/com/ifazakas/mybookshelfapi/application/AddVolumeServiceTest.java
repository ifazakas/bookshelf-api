package com.ifazakas.mybookshelfapi.application;

import com.ifazakas.mybookshelfapi.domain.Volume;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddVolumeServiceTest {
  private static final int PUBLICATION_YEAR_OF_REFACTORING = 1999;
  private AddVolumeService addVolumeService;

  @Before
  public void setUp() throws Exception {
    addVolumeService = new AddVolumeService();
  }

  @Test
  public void shouldAddABook() throws Exception {
    //when
    Volume actualVolume = addVolumeService.addVolume(
        "Martin Fowler",
        "Refactoring",
        PUBLICATION_YEAR_OF_REFACTORING
    );

    //then
    assertThat(actualVolume).isNotNull();

  }
}
