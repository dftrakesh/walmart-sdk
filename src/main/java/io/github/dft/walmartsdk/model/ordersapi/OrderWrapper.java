package io.github.dft.walmartsdk.model.ordersapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.walmartsdk.model.common.Errors;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderWrapper {

    private Order order;
    private Errors errors;
}