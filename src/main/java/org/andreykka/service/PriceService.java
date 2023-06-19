package org.andreykka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.andreykka.dto.PricesDTO;
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

    @Scheduled(cron = "${scheduler.interval}")
    void getPrices() throws JsonProcessingException {
        LOGGER.info("Started pulling prices from stockData...");
        PricesDTO currentPrices = coinMarketClient.getCurrentPrices();
        LOGGER.info(currentPrices.toString());
    }
}
