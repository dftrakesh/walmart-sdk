package io.github.dft.walmartsdk.model.wfsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

    private String inboundOrderId;
    private String shipmentId;
    private ShipToAddress shipToAddress;
    private ReturnAddress returnAddress;
    private String status;
    private String createdDate;
    private Integer shipmentUnits;
    private Integer receivedUnits;
    private String expectedDeliveryDate;
    private String updatedExpectedDeliveryDate;
    private List<String> trackingNo;
    private String carrierName;
    private String movedShipmentId;
}