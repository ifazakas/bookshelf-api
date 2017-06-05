package com.ifazakas.mybookshelfapi.domain;

import java.util.UUID;

public final class VolumeId {
  private final UUID id;

  private VolumeId(final UUID id) {
    this.id = id;
  }

  static VolumeId createId() {
    return new VolumeId(UUID.randomUUID());
  }

  static VolumeId wakeUp(final String uuidValue) {
    return new VolumeId(UUID.fromString(uuidValue));
  }

  public String getValue() {
    return id.toString();
  }

  @Override
  @SuppressWarnings("checkstyle:avoidinlineconditionals")
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    VolumeId volumeId = (VolumeId) o;

    return id != null ? id.equals(volumeId.id) : volumeId.id == null;

  }

  @Override
  @SuppressWarnings("checkstyle:avoidinlineconditionals")
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
