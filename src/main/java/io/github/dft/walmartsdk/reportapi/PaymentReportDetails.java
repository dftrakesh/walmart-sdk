package io.github.dft.walmartsdk.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentReportDetails {

    @JsonProperty("Shipping Method")
    private String shippingMethod;

    @JsonProperty("Partner Item Name")
    private String partnerItemName;

    @JsonProperty("Customer Order line #")
    private String customerOrderLine;

    @JsonProperty("Fulfillment Details")
    private String fulfillmentDetails;

    @JsonProperty("Commission Rule")
    private String commissionRule;

    @JsonProperty("Contract Category")
    private String contractCategory;

    @JsonProperty("Transaction Description")
    private String transactionDescription;

    @JsonProperty("Product Tax Code")
    private String productTaxCode;

    @JsonProperty("Period Start Date")
    private String periodStartDate;

    @JsonProperty("Ship to Zipcode")
    private String shipToZipcode;

    @JsonProperty("Ship to City")
    private String shipToCity;

    @JsonProperty("Transaction Key")
    private String transactionKey;

    @JsonProperty("Transaction Posted Timestamp")
    private String transactionPostedTimestamp;

    @JsonProperty("Ship Qty")
    private Integer ShipQty;

    @JsonProperty("Amount")
    private Double amount;

    @JsonProperty("Transaction Type")
    private String transactionType;

    @JsonProperty("Partner GTIN")
    private String partnerGTIN;

    @JsonProperty("Ship to State")
    private String shipToState;

    @JsonProperty("Amount Type")
    private String amountType;

    @JsonProperty("Fulfillment Type")
    private String fulfillmentType;

    @JsonProperty("Customer Order #")
    private String customerOrder;

    @JsonProperty("Purchase Order #")
    private String purchaseOrder;

    @JsonProperty("Product Type")
    private String productType;

    @JsonProperty("Original Commission")
    private Double originalCommission;

    @JsonProperty("Partner Item Id")
    private String partnerItemId;

    @JsonProperty("Purchase Order line #")
    private String purchaseOrderLine;
}
