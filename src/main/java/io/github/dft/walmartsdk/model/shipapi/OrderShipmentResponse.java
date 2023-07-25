package io.github.dft.walmartsdk.model.shipapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.walmartsdk.model.common.Errors;
import io.github.dft.walmartsdk.model.ordersapi.Order;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderShipmentResponse {

    private Order order;
    private Errors errors;
}