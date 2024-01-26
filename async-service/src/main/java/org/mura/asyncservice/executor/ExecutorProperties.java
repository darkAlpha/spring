package org.mura.asyncservice.executor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("executor")
public record ExecutorProperties(
        int corePoolSize,
        int maxPoolSize,
        int queueCapacity) {
}
