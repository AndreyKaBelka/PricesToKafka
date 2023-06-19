package org.andreykka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "kafka")
@Data
@Configuration
public class KafkaConfig {
    String url;
    String topic;
}
