package io.github.dft.walmartsdk.model.returnsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnTrackingDetail {

    private Integer sequenceNo;
    private String eventTag;
    private String eventDescription;
    private String eventTime;
    private List<Reference> references;
}