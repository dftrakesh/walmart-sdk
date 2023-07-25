package io.github.dft.walmartsdk.model.feedsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.dft.walmartsdk.model.common.Errors;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedWrapper {

    private Integer totalResults;
    private Integer offset;
    private Integer limit;
    private Results results;
    private Errors errors;
}