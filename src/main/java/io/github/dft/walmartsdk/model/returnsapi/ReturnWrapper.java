package io.github.dft.walmartsdk.model.returnsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.walmartsdk.model.common.Errors;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnWrapper {

    private Meta meta;
    private List<ReturnOrder> returnOrders;
    private Errors errors;
}