package org.andreykka.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteDTO {
    Double price;
    @JsonProperty("volume_24h")
    Long volume24h;
    @JsonProperty("percent_change_1h")
    Double percentChange1h;
    @JsonProperty("percent_change_24h")
    Double percentChange24h;
    @JsonProperty("percent_change_7d")
    Double percentChange7d;
    @JsonProperty("percent_change_30d")
    Double percentChange30d;
    @JsonProperty("percent_change_60d")
    Double percentChange60d;
    @JsonProperty("percent_change_90d")
    Double percentChange90d;
    Date lastUpdated;
}


