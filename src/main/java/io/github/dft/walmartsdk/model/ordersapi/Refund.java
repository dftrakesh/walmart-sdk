package io.github.dft.walmartsdk.model.ordersapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Refund {

    private String refundId;
    private String refundComments;
    private RefundCharges refundCharges;
}