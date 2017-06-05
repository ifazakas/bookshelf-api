package com.ifazakas.mybookshelfapi.application;

import com.ifazakas.mybookshelfapi.domain.Volume;
import com.ifazakas.mybookshelfapi.domain.VolumeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

public class AddVolumeServiceTest {
  private static final String AUTHOR_OF_REFACTORING = "Martin Fowler";
  private static final String TITLE_OF_REFACTORING = "Refactoring";
  private static final int PUBLICATION_YEAR_OF_REFACTORING = 1999;
  private AddVolumeService addVolumeService;
  private VolumeRepository volumeRepository;



  @Before
  public void setUp() throws Exception {
    volumeRepository = Mockito.mock(VolumeRepository.class);
    addVolumeService = new AddVolumeService(volumeRepository);
  }

  @Test
  public void shouldAddAVolumeToTheRepository() throws Exception {
    //when
    Volume actualVolume = addVolumeService.addVolume(
        AUTHOR_OF_REFACTORING,
        TITLE_OF_REFACTORING,
        PUBLICATION_YEAR_OF_REFACTORING
    );

    //then
    assertThat(actualVolume).isNotNull();
    verify(volumeRepository).persist(isA(Volume.class));
  }
}
