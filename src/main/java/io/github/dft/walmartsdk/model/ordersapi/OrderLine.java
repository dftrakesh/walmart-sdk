package io.github.dft.walmartsdk.model.ordersapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLine {

    private String lineNumber;
    private Item item;
    private Charges charges;
    private OrderLineQuantity orderLineQuantity;
    private Long statusDate;
    private OrderLineStatuses orderLineStatuses;
    private Fulfillment fulfillment;
    private Object refund;
}