package com.ifazakas.mybookshelfapi.domain;

import java.util.UUID;

public class VolumeId {
  private final UUID id;

  private VolumeId(UUID id) {
    this.id = id;
  }

  public String getValue() {
    return id.toString();
  }

  public static VolumeId createId() {
    return new VolumeId(UUID.randomUUID());
  }
}
