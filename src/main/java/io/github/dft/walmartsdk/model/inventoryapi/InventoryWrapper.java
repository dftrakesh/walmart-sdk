package io.github.dft.walmartsdk.model.inventoryapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.walmartsdk.model.common.Errors;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryWrapper {

    private String sku;
    private Quantity quantity;
    private Errors errors;
}