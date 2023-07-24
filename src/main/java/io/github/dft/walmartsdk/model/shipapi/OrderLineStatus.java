package io.github.dft.walmartsdk.model.shipapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.walmartsdk.model.ordersapi.ReturnCenterAddress;
import io.github.dft.walmartsdk.model.ordersapi.StatusQuantity;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderLineStatus {

    private String status;
    private StatusQuantity statusQuantity;
    private TrackingInfo trackingInfo;
    private ReturnCenterAddress returnCenterAddress;
}