package org.andreykka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.andreykka.config.KafkaConfig;
import org.andreykka.dto.QuoteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaConfig kafkaConfig;
    @Autowired
    private ObjectMapper objectMapper;

    public void sendToKafka(QuoteDTO quoteDTO, String currencyName) throws JsonProcessingException {
        LOGGER.info("Send message to kafka...");
        String topic = getTopicByName(currencyName);
        kafkaTemplate.send(topic, objectMapper.writeValueAsString(quoteDTO));
    }

    private String getTopicByName(String currencyName) {
        switch (currencyName) {
            case "BTC" -> {
                return kafkaConfig.getBitcoinTopic();
            }
            case "ETH" -> {
                return kafkaConfig.getEtheriumTopic();
            }
            default -> throw new RuntimeException("Something went wrong...");
        }
    }
}
