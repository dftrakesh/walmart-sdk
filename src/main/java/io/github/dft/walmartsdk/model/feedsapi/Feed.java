package io.github.dft.walmartsdk.model.feedsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feed {

    private String feedId;
    private String feedSource;
    private String feedType;
    private String partnerId;
    private Integer itemsReceived;
    private Integer itemsSucceeded;
    private Integer itemsFailed;
    private Integer itemsProcessing;
    private String feedStatus;
    private Long feedDate;
    private Long modifiedDtm;
    private String fileName;
    private Integer itemDataErrorCount;
    private Integer itemSystemErrorCount;
    private Integer itemTimeoutErrorCount;
    private String channelType;
    private String orgId;
    private String shipNode;
}