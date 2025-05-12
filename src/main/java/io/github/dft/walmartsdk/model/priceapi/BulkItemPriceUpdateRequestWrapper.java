package io.github.dft.walmartsdk.model.priceapi;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class BulkItemPriceUpdateRequestWrapper {

    public BulkItemPriceUpdateHeader priceHeader;
    public List<PriceUpdateRequestWrapper> price;
}
