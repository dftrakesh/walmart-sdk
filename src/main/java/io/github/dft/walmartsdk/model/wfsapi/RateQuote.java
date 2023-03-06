package io.github.dft.walmartsdk.model.wfsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateQuote {

    private String quoteId;
    private String estimatedDeliveryDateTime;
    private Carrier carrier;
    private String currency;
    private Integer discountCharge;
    private Integer netCharge;
    private String surchargeType;
    private String surchargeValue;
    private Integer totalBillingWeight;
    private String status;
    private String transitDays;
    private String effectiveDate;
    private String expiryDate;
    private String mode;
    private String sellerFreightClassCode;
    private Integer freightCharge;
    private Integer fuelCharge;
    private Integer totalWeight;
    private Integer totalVolume;
    private String equipmentTypeCode;
    private String serviceCode;
    private Integer numberOfPallets;
    private Integer nominalCharge;
    private Integer assessorialCharge;
    private Integer serviceCharge;
    private Integer minimumCharge;
    private String declaredValue;
    private Integer mixedSKUs;
    private Integer singleSKUs;
    private String freightReadyDate;
}