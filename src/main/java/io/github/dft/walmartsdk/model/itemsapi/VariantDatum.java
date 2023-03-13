package io.github.dft.walmartsdk.model.itemsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariantDatum {

    private String productImageUrl;
    private String itemId;
    private String isAvailable;
    private String title;
    private List<VariantValue> variantValues;
}