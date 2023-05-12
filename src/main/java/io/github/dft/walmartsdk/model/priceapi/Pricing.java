package io.github.dft.walmartsdk.model.priceapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pricing {
    public CurrentPriceType currentPriceType;
    public CurrentPrice currentPrice;
}