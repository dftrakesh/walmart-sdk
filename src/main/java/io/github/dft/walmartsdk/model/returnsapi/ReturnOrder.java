package io.github.dft.walmartsdk.model.returnsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnOrder {

    private String returnOrderId;
    private String customerEmailId;
    private CustomerName customerName;
    private String customerOrderId;
    private String refundMode;
    private String returnOrderDate;
    private String returnType;
    private String replacementCustomerOrderId;
    private String returnByDate;
    private TotalRefundAmount totalRefundAmount;
    private List<ReturnLineGroup> returnLineGroups;
    private List<ReturnOrderLine> returnOrderLines;
    private ReturnChannel returnChannel;
}