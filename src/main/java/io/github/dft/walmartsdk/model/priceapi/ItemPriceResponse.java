package io.github.dft.walmartsdk.model.priceapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPriceResponse {
    private String sku;
    private String mart;
    private String message;
    private Integer statusCode;
}