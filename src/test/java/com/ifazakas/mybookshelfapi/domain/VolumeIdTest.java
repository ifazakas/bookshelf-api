package com.ifazakas.mybookshelfapi.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class VolumeIdTest {
  private static final String A_UUID = "c557009a-3430-11e7-b687-92ebcb67fe33";
  @Test
  public void shouldCreateAnId() throws Exception {
    VolumeId aVolumeId = VolumeId.createId();

    assertThat(aVolumeId).isNotNull();
    assertThat(aVolumeId.getValue()).isNotNull();
  }

  @Test
  public void shouldWakeUpAVolumeIdWithAUUIDValue() throws Exception {
    VolumeId aVolumeId = VolumeId.wakeUp(A_UUID);

    assertThat(aVolumeId.getValue()).isEqualTo(A_UUID);
  }

  @Test
  public void shouldBeIdenticalToAnotherVolumeIdWithTheSameValue() throws Exception {
    VolumeId aVolumeId = VolumeId.createId();
    VolumeId anotherVolumeId = VolumeId.wakeUp(aVolumeId.getValue());

    assertThat(aVolumeId.equals(anotherVolumeId)).isTrue();
    assertThat(aVolumeId.hashCode()).isEqualTo(anotherVolumeId.hashCode());

    assertThat(aVolumeId.equals(VolumeId.createId())).isFalse();

  }
}
