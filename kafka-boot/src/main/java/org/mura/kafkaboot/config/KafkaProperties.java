package org.mura.kafkaboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka.custom")
public record KafkaProperties(
        String host,
        String user,
        String password
) {
}
