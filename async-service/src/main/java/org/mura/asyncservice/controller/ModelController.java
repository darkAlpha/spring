package org.mura.asyncservice.controller;

import lombok.RequiredArgsConstructor;
import org.mura.asyncservice.dto.ModelDTO;
import org.mura.asyncservice.lifecycle.ProcessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/api")
public class ModelController {

    private final ProcessService processService;

    @GetMapping(path = "/start")
    public ResponseEntity<ModelDTO> start() {

        processService.start(new ModelDTO("1111111","1111111","11111111", LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()), "STATUS"));

        return ResponseEntity.ok(new ModelDTO("1111111","1111111","11111111", LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()), "STATUS"));
    }

}
