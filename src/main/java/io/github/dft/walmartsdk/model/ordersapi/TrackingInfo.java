package io.github.dft.walmartsdk.model.ordersapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackingInfo {

    private Long shipDateTime;
    private CarrierName carrierName;
    private String methodCode;
    private String carrierMethodCode;
    private String trackingNumber;
    private String trackingURL;
}