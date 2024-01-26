package org.mura.asyncservice.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mura.asyncservice.entity.Model;
import org.mura.asyncservice.repository.ModelRepository;
import org.mura.asyncservice.service.ModelService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Slf4j
@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Async
    @Override
    public void action() {

        try {
            log.info("calling action service...");
            Thread.sleep(10000L);
            log.info("finished action");
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    @Async
    @Override
    public void doSave() {
        try {
            log.info("calling doService service...");
            Thread.sleep(1000L);

            save();

            log.info("finished doService");
        }
        catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void save() {
        modelRepository.saveAndFlush(new Model()
                .setCreateTime(LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()))
                .setMessage("message"));
    }
}
