package io.github.dft.walmartsdk.model.wfsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipToAddress {

    private String fcName;
    private String addressLine1;
    private String city;
    private String stateCode;
    private String countryCode;
    private String postalCode;
}