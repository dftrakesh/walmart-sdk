package io.github.dft.walmartsdk.model.priceapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPriceResponseWrapper {

    @JsonProperty("ItemPriceResponse")
    private ItemPriceResponse itemPriceResponse;
}