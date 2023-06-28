package org.andreykka.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class CurrentPriceMixIn {
    @JsonProperty("e")
    String event;
    @JsonProperty("E")
    Long time;
    @JsonProperty("s")
    String symbol;
    @JsonProperty("p")
    Double price;
    @JsonProperty("P")
    Double indexPrice;
    @JsonProperty("i")
    Double settlePrice;
    @JsonProperty("r")
    Double rate;
    @JsonProperty("T")
    Double nextFundingTime;

    @JsonIgnore
    abstract void getSchema();
}
