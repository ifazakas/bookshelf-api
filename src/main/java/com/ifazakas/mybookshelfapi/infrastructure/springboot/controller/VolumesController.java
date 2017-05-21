package com.ifazakas.mybookshelfapi.infrastructure.springboot.controller;

import com.ifazakas.mybookshelfapi.application.AddVolumeService;
import com.ifazakas.mybookshelfapi.domain.Volume;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httprequestbody.AddBookHttpRequestBody;
import com.ifazakas.mybookshelfapi.infrastructure.springboot.controller.httpresponsebody.AddBookHttpResponseBody;
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
  public ResponseEntity<AddBookHttpResponseBody> addVolume(@RequestBody final AddBookHttpRequestBody httpRequestBody) {

    Volume volume = addVolumeService.addVolume(
        httpRequestBody.getAuthor(),
        httpRequestBody.getTitle(),
        httpRequestBody.getPublicationYear()
    );

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(AddBookHttpResponseBody.createFrom(volume));
  }

}
