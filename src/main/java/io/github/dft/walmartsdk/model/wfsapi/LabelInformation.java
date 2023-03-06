package io.github.dft.walmartsdk.model.wfsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LabelInformation {

    private String labelData;
    private String labelFormat;
    private String trackingCode;
    private String referenceTrackingCode;
    private String epTrackerId;
    private String shipmentId;
    private String packageAsn;
    private String masterTrackingCode;
    private Boolean master;
}