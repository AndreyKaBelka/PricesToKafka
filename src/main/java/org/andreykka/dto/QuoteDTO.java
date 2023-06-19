package org.andreykka.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    Double volume24h;
    Double percentChange1h;
    Double percentChange24h;
    Double percentChange7d;
    Double percentChange30d;
    Double percentChange60d;
    Double percentChange90d;
    Date lastUpdated;
}


