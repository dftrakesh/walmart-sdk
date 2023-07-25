package io.github.dft.walmartsdk.model.itemsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.dft.walmartsdk.model.common.Errors;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemWrapper {

    @JsonProperty("ItemResponse")
    private List<ItemResponse> ItemResponse;
    private Integer totalItems;
    private Errors errors;
}
