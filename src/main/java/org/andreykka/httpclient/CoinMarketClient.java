package org.andreykka.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.andreykka.config.CoinMarketConfig;
import org.andreykka.dto.PricesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class CoinMarketClient {

    @Autowired
    CoinMarketConfig coinMarketConfig;

    @Autowired
    ObjectMapper objectMapper;

    @SneakyThrows
    public PricesDTO getCurrentPrices() {
        HttpResponse<String> response = HttpClient.newHttpClient().send(
                HttpRequest.newBuilder().GET().header("X-CMC_PRO_API_KEY", coinMarketConfig.getToken()).uri(getCurrentPricesURL()).build(),
                HttpResponse.BodyHandlers.ofString()
        );

        return objectMapper.readValue(response.body(), PricesDTO.class);
    }

    @SneakyThrows
    private URI getCurrentPricesURL() {
        return new URI("%s?convert=%s&symbol=%s".formatted(
                coinMarketConfig.getRealTimeUrl(),
                coinMarketConfig.getConvert(),
                coinMarketConfig.getSymbol()
        ));
    }
}
