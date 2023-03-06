package io.github.dft.walmartsdk.model.returnsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Charge {

    private String chargeCategory;
    private String chargeName;
    private ChargePerUnit chargePerUnit;
    private Boolean isDiscount;
    private Boolean isBillable;
    private List<Tax> tax;
    private ExcessCharge excessCharge;
    private List<Reference> references;
}