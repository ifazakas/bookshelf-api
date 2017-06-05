package com.ifazakas.mybookshelfapi.infrastructure.jpa;

import com.ifazakas.mybookshelfapi.domain.Volume;
import com.ifazakas.mybookshelfapi.domain.VolumeRepository;

public class JpaVolumeRepositoryService implements VolumeRepository {
  private final JpaVolumeRepository jpaVolumeRepository;

  public JpaVolumeRepositoryService(final JpaVolumeRepository jpaVolumeRepository) {
    this.jpaVolumeRepository = jpaVolumeRepository;
  }


  @Override
  public void persist(final Volume volume) {

    JpaVolume jpaVolume = mapVolumeToJpaVolume(volume);
    jpaVolumeRepository.save(jpaVolume);
  }

  private JpaVolume mapVolumeToJpaVolume(final Volume volume) {

    return new JpaVolume(
        volume.getId().getValue(),
        volume.getAuthor().getName(),
        volume.getTitle().getValue(),
        volume.getPublicationYear().getValue()
    );
  }
}
