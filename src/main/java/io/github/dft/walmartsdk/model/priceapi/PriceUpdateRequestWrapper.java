package io.github.dft.walmartsdk.model.priceapi;

import lombok.Data;

import java.util.List;

@Data
public class PriceUpdateRequestWrapper {

    private String sku;
    private List<Pricing> pricing;
}
