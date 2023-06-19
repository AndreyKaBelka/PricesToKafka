package org.andreykka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "coin-market")
@Configuration
public class CoinMarketConfig {
    String realTimeUrl;
    String token;
    String symbol;
    String convert;
}
