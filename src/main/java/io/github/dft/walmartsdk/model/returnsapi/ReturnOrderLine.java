package io.github.dft.walmartsdk.model.returnsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnOrderLine {

    private Integer returnOrderLineNumber;
    private Integer salesOrderLineNumber;
    private String returnReason;
    private String purchaseOrderId;
    private String sellerOrderId;
    private Integer purchaseOrderLineNumber;
    private Boolean isReturnForException;
    private String exceptionItemType;
    private String rechargeReason;
    private String returnCancellationReason;
    private Item item;
    private List<Charge> charges;
    private UnitPrice unitPrice;
    private List<ChargeTotal> chargeTotals;
    private String currentDeliveryStatus;
    private String currentRefundStatus;
    private Integer cancellableQty;
    private Quantity quantity;
    private Boolean returnExpectedFlag;
    private Boolean isFastReplacement;
    private Boolean isKeepIt;
    private Boolean lastItem;
    private Integer refundedQty;
    private Integer rechargeableQty;
    private String refundChannel;
    private List<ReturnTrackingDetail> returnTrackingDetail;
    private String status;
    private String statusTime;
}