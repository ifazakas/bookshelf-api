package com.ifazakas.mybookshelfapi.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class VolumeIdTest {
  @Test
  public void shouldCreateAnId() throws Exception {
    VolumeId aVolumeId = VolumeId.createId();

    assertThat(aVolumeId).isNotNull();
    assertThat(aVolumeId.getValue()).isNotNull();
  }
}