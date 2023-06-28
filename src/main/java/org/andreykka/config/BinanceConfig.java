package org.andreykka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "binance")
@Configuration
public class BinanceConfig {
    String realTimeUrl;
    String symbol;
    String currentPriceStreamName;
}
