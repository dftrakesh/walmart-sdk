package io.github.dft.walmartsdk.model.wfsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentPackage {

    private Integer packageSequenceNumber;
    private Integer weight;
    private String weightUOM;
    private Integer length;
    private Integer height;
    private Integer width;
    private String lengthUOM;
    private LabelInformation labelInformation;
    private Integer billingWeight;
    private Integer netCharge;
    private Integer nominalCharge;
    private Integer assessorialCharge;
    private Integer serviceCharge;
    private String packageType;
    private Integer noOfPackages;
    private Boolean stackable;
}