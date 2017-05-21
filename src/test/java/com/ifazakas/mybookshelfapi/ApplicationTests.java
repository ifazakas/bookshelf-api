package com.ifazakas.mybookshelfapi;

import com.ifazakas.mybookshelfapi.infrastructure.springboot.Application;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.AddVolumeController;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.PingController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

  @Autowired
  private PingController pingController;
  @Autowired
  private AddVolumeController addVolumeController;

  @Test
  public void contextLoads() {
    assertThat(pingController).isNotNull();
    assertThat(addVolumeController).isNotNull();
  }

}
