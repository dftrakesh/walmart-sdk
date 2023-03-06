package io.github.dft.walmartsdk.model.ordersapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingInfo {

    private String phone;
    private Long estimatedDeliveryDate;
    private Long estimatedShipDate;
    private String methodCode;
    private PostalAddress postalAddress;
}