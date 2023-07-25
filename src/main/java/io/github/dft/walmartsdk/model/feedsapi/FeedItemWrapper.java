package io.github.dft.walmartsdk.model.feedsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.walmartsdk.model.common.Errors;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedItemWrapper {

    private String feedId;
    private String feedStatus;
    private Long feedSubmissionDate;
    private Integer itemsReceived;
    private Integer itemsSucceeded;
    private Integer itemsFailed;
    private Integer itemsProcessing;
    private Integer offset;
    private Integer limit;
    private ItemDetails itemDetails;
    private Errors errors;
}