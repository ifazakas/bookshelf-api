package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.application.AddVolumeService;
import com.ifazakas.mybookshelfapi.domain.Volume;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httprequestbody.AddVolumeHttpRequestBody;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httpresponsebody.AddVolumeHttpResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/volumes")
public class VolumesController implements VolumesControllerExceptionHandler {

  private final AddVolumeService addVolumeService;

  public VolumesController(final AddVolumeService addVolumeService) {
    this.addVolumeService = addVolumeService;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<AddVolumeHttpResponseBody> addVolume(@RequestBody final AddVolumeHttpRequestBody httpRequestBody) {

    Volume volume = addVolumeService.addVolume(
        httpRequestBody.getAuthor(),
        httpRequestBody.getTitle(),
        httpRequestBody.getPublicationYear()
    );

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(AddVolumeHttpResponseBody.createFrom(volume));
  }

}
