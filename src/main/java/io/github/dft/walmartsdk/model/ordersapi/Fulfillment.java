package io.github.dft.walmartsdk.model.ordersapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fulfillment {

    private String fulfillmentOption;
    private String shipMethod;
    private String storeId;
    private Long pickUpDateTime;
    private String pickUpBy;
    private String shippingProgramType;
}