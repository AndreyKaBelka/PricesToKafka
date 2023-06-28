package org.andreykka.service;

import org.andreykka.config.KafkaConfig;
import org.andreykka.dto.CurrentPrice;
import org.apache.avro.generic.GenericRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    private KafkaTemplate<String, GenericRecord> kafkaTemplate;
    @Autowired
    private KafkaConfig kafkaConfig;

    public void sendToKafkaCurrentPrices(CurrentPrice currentPrice, String currencyName) {
        LOGGER.info("Send message to kafka...");
        String topic = getTopicByName(currencyName);
        kafkaTemplate.send(topic, currentPrice);
    }

    private String getTopicByName(String currencyName) {
        switch (currencyName) {
            case "BTCUSDT" -> {
                return kafkaConfig.getBitcoinTopic();
            }
            case "ETH" -> {
                return kafkaConfig.getEtheriumTopic();
            }
            default -> throw new RuntimeException("Something went wrong...");
        }
    }
}
