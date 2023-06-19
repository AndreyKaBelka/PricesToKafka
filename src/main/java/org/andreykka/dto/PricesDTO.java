package org.andreykka.dto;

import lombok.Data;

import java.util.Map;

@Data
public class PricesDTO {
    StatusDTO status;
    Map<String, TokenPriceDTO> data;
}
