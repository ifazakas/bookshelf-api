package com.ifazakas.mybookshelfapi.application;

import com.ifazakas.mybookshelfapi.domain.Author;
import com.ifazakas.mybookshelfapi.domain.PublicationYear;
import com.ifazakas.mybookshelfapi.domain.Title;
import com.ifazakas.mybookshelfapi.domain.Volume;

public class AddVolumeService {
  public Volume addVolume(
      final String author,
      final String title,
      final int publicationYear
  ) {


    return new Volume(
        new Author(author),
        new Title(title),
        new PublicationYear(publicationYear)
    );
  }
}
