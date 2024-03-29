package io.github.dft.walmartsdk.model.itemsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {

    @JsonProperty("variant_items_num")
    private String variantItemsNum;
    @JsonProperty("num_reviews")
    private String numReviews;
    private List<String> categories;
    private Variants variants;
    @JsonProperty("next_day_eligible")
    private Boolean nextDayEligible;
}