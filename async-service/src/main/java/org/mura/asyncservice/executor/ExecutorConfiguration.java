package org.mura.asyncservice.executor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@RequiredArgsConstructor
@Configuration
public class ExecutorConfiguration {

    private final ExecutorProperties executorProperties;

    @Bean
    public Executor executor() {

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        threadPoolTaskExecutor.setCorePoolSize(executorProperties.corePoolSize());
        threadPoolTaskExecutor.setMaxPoolSize(executorProperties.maxPoolSize());
        threadPoolTaskExecutor.setQueueCapacity(executorProperties.queueCapacity());
        threadPoolTaskExecutor.setThreadNamePrefix("async-");
        threadPoolTaskExecutor.initialize();
//        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);

        return threadPoolTaskExecutor;
    }

}
