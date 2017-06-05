package com.ifazakas.mybookshelfapi.application;

import com.ifazakas.mybookshelfapi.domain.Author;
import com.ifazakas.mybookshelfapi.domain.PublicationYear;
import com.ifazakas.mybookshelfapi.domain.Title;
import com.ifazakas.mybookshelfapi.domain.Volume;
import com.ifazakas.mybookshelfapi.domain.VolumeRepository;

public class AddVolumeService {
  private VolumeRepository volumeRepository;

  public AddVolumeService(VolumeRepository volumeRepository) {
    this.volumeRepository = volumeRepository;
  }

  public Volume addVolume(
      final String author,
      final String title,
      final int publicationYear
  ) {


    Volume theVolume = new Volume(
        new Author(author),
        new Title(title),
        new PublicationYear(publicationYear)
    );

    volumeRepository.persist(theVolume);

    return theVolume;
  }
}
