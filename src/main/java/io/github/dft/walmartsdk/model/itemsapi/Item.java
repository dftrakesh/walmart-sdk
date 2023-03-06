package io.github.dft.walmartsdk.model.itemsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private String itemId;
    private Boolean isMarketPlaceItem;
    private List<Image> images;
    private String customerRating;
    private Boolean freeShipping;
    private Integer offerCount;
    private Price price;
    private String description;
    private String title;
    private String brand;
    private String productType;
    private Properties properties;
}