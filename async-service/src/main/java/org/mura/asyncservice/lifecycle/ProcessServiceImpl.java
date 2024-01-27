package org.mura.asyncservice.lifecycle;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mura.asyncservice.dto.ModelDTO;
import org.mura.asyncservice.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProcessServiceImpl implements ProcessService {

    private final ModelService modelService;

    private final Executor executor;

    @Override
    public void start(ModelDTO modelDTO) {
        resultByGet();
        resultByJoin();
        timeout();
    }

    private void timeout() {
        try {

            CompletableFuture<String> start = CompletableFuture.supplyAsync(() -> {
                        try {
                            Thread.sleep(10L);
                        } catch (Exception e) {

                        }

                        return "1";
                    })
                    .completeOnTimeout("No", 100, TimeUnit.MILLISECONDS);


            log.info(start.get());


        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void resultByGet() {
        try {

            CompletableFuture<Void> start = CompletableFuture
                    .runAsync(modelService::doSave).orTimeout(1000, TimeUnit.MILLISECONDS);

            CompletableFuture<Void> continues = CompletableFuture
                    .runAsync(modelService::action).orTimeout(1000, TimeUnit.MILLISECONDS);

            start.get();
            continues.get();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void resultByJoin() {
        try {

            CompletableFuture<Void> start = CompletableFuture
                    .runAsync(modelService::doSave).orTimeout(1000, TimeUnit.MILLISECONDS);

            CompletableFuture<Void> continues = CompletableFuture
                    .runAsync(modelService::action).orTimeout(1000, TimeUnit.MILLISECONDS);


            CompletableFuture.allOf(start, continues).join();

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void asyncMethod() {
        try {

            CompletableFuture<String> asyncStartWithExecutor = CompletableFuture
                    .supplyAsync(() -> "1", executor);

            CompletableFuture<String> asyncStart = CompletableFuture
                    .supplyAsync(() -> "1");

            CompletableFuture<String> complete = new CompletableFuture<>();

            simulateLongRunningTask(complete);

            complete.completeOnTimeout("TimeoutValue", 1, TimeUnit.MILLISECONDS);


        } catch (Exception e) {

        }
    }

    private void simulateLongRunningTask(CompletableFuture<String> future) {
        // Simulate a long-running task that takes more than 1 second
        new Thread(() -> {
            try {
                // Simulating a task that takes 5 seconds
                Thread.sleep(5000);
                future.complete("Task Result");
            } catch (InterruptedException e) {
                // Handle interruption if needed
                future.completeExceptionally(e);
            }
        }).start();
    }
}
