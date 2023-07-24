package io.github.dft.walmartsdk.model.shipapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLine {

    private Integer lineNumber;
    private Boolean intentToCancelOverride;
    private String sellerOrderId;
    private OrderLineStatuses orderLineStatuses;
}