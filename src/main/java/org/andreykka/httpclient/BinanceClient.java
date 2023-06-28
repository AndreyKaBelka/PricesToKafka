package org.andreykka.httpclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.andreykka.config.BinanceConfig;
import org.andreykka.dto.CurrentPrice;
import org.andreykka.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;

import java.net.URI;

@Component
public class BinanceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinanceClient.class);

    @Autowired
    BinanceConfig binanceConfig;

    @Autowired
    ReactorNettyWebSocketClient webSocketClient;

    @Autowired
    KafkaService kafkaService;

    @Autowired
    ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        LOGGER.info("Connecting to websocket...");
        webSocketClient.execute(getCurrentPricesURL(), session ->
                session.receive()
                        .doOnSubscribe(subscription -> LOGGER.info("Connected..."))
                        .map(message -> {
                            try {
                                return objectMapper.readValue(message.getPayloadAsText(), CurrentPrice.class);
                            } catch (JsonProcessingException e) {
                                LOGGER.error("Cannot deserialize json", e);
                                return null;
                            }
                        })
                        .doOnNext(message -> kafkaService.sendToKafkaCurrentPrices(message, message.getSymbol()))
                        .doOnError(error -> LOGGER.error("Something went wrong: ", error))
                        .then()
        ).subscribe();
    }

    @SneakyThrows
    private URI getCurrentPricesURL() {
        return new URI("%s/ws/%s@%s".formatted(binanceConfig.getRealTimeUrl(), binanceConfig.getSymbol(), binanceConfig.getCurrentPriceStreamName()));
    }
}
