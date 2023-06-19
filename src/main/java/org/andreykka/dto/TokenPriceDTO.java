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
public class TokenPriceDTO {
    Integer id;
    String name;
    String symbol;
    String slug;
    Date lastUpdated;

    @JsonProperty("quote")
    @SkipWrapperObject("USD")
    @JsonDeserialize(contentUsing = SkipWrapperObjectDeserializer.class)
    QuoteDTO quote;
}
