package com.ifazakas.mybookshelfapi.application;

import com.ifazakas.mybookshelfapi.domain.Volume;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddVolumeServiceTest {
  private AddVolumeService addVolumeService;

  @Before
  public void setUp() throws Exception {
    addVolumeService = new AddVolumeService();
  }

  @Test
  @SuppressWarnings("checkstyle:magicnumber")
  public void shouldAddABook() throws Exception {
    //when
    Volume actualVolume = addVolumeService.addVolume("Martin Fowler", "Refactoring", 1999);

    //then
    assertThat(actualVolume).isNotNull();

  }
}
