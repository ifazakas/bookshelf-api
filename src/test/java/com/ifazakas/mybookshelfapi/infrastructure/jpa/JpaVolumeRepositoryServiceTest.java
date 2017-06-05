package com.ifazakas.mybookshelfapi.infrastructure.jpa;

import com.ifazakas.mybookshelfapi.domain.Author;
import com.ifazakas.mybookshelfapi.domain.PublicationYear;
import com.ifazakas.mybookshelfapi.domain.Title;
import com.ifazakas.mybookshelfapi.domain.Volume;
import com.ifazakas.mybookshelfapi.domain.VolumeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;

public class JpaVolumeRepositoryServiceTest {
  private static final String AUTHOR_OF_REFACTORING = "Martin Fowler";
  private static final String TITLE_OF_REFACTORING = "Refactoring";
  private static final int PUBLICATION_YEAR_OF_REFACTORING = 1999;

  private JpaVolumeRepository jpaVolumeRepository;
  private VolumeRepository volumeRepository;

  @Before
  public void setUp() throws Exception {
    jpaVolumeRepository = Mockito.mock(JpaVolumeRepository.class);
    volumeRepository = new JpaVolumeRepositoryService(jpaVolumeRepository);
  }

  @Test
  public void givenAVolumeShouldPersistAJpaVolume() throws Exception {
    //given
    Volume aVolume = new Volume(
        new Author(AUTHOR_OF_REFACTORING),
        new Title(TITLE_OF_REFACTORING),
        new PublicationYear(PUBLICATION_YEAR_OF_REFACTORING)
    );

    //when
    volumeRepository.persist(aVolume);

    //then
    verify(jpaVolumeRepository).save(isA(JpaVolume.class));
  }
}
