package io.github.dft.walmartsdk.model.wfsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarrierShipment {

    private String shipmentId;
    private String quoteId;
    private String estimatedDeliveryDateTime;
    private String quoteCreationDate;
    private Carrier carrier;
    private RateQuote rateQuote;
    private List<ShipmentPackage> shipmentPackages;
    private OriginLocation originLocation;
    private DestinationLocation destinationLocation;
    private ReturnLocation returnLocation;
}