package io.github.dft.walmartsdk.model.shipapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.walmartsdk.model.ordersapi.CarrierName;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingInfo {

    private Long shipDateTime;
    private CarrierName carrierName;
    private String methodCode;
    private String trackingNumber;
    private String trackingURL;
}