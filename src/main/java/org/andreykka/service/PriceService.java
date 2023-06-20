package org.andreykka.service;

import lombok.SneakyThrows;
import org.andreykka.dto.PricesDTO;
import org.andreykka.dto.TokenPriceDTO;
import org.andreykka.httpclient.CoinMarketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class PriceService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceService.class);

    @Autowired
    CoinMarketClient coinMarketClient;

    @Autowired
    KafkaService kafkaService;

    @Scheduled(cron = "${scheduler.interval}")
    void getPrices() {
        LOGGER.info("Started pulling prices from coinMarket...");
        PricesDTO currentPrices = coinMarketClient.getCurrentPrices();
        LOGGER.info("Prices pulled successfully...");
        currentPrices.getData().forEach(this::sendMessage);
    }

    @SneakyThrows
    private void sendMessage(String cur, TokenPriceDTO tokenPrice) {
        kafkaService.sendToKafka(tokenPrice.getQuote(), cur);
    }
}
