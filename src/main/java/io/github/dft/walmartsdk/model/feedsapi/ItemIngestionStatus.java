package io.github.dft.walmartsdk.model.feedsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemIngestionStatus {

    private Integer martId;
    private String sku;
    private String wpId;
    private Integer index;
    private String itemId;
    private ProductIdentifiers productIdentifiers;
    private String ingestionStatus;
}
