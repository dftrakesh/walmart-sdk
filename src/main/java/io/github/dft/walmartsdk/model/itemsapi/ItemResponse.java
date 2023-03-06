package io.github.dft.walmartsdk.model.itemsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse {

    private String mart;
    private String sku;
    private String wpid;
    private String upc;
    private String gtin;
    private String productName;
    private String shelf;
    private String productType;
    private Price price;
    private String publishedStatus;
    private UnpublishedReasons unpublishedReasons;
    private String lifecycleStatus;
    private VariantGroupInfo variantGroupInfo;
    private String variantGroupId;

}