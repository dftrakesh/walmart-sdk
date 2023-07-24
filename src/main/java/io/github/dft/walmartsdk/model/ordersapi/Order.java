package io.github.dft.walmartsdk.model.ordersapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private String purchaseOrderId;
    private String customerOrderId;
    private String customerEmailId;
    private String sellerOrderId;
    private String orderType;
    private String originalCustomerOrderID;
    private Long orderDate;
    private ShippingInfo shippingInfo;
    private OrderLines orderLines;
    public ShipNode shipNode;
}