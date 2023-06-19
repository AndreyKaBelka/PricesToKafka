package org.andreykka.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.Date;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StatusDTO {
    Date timestamp;
    int errorCode;
    String errorMessage;
    int elapsed;
    int creditCount;
    String notice;
}
