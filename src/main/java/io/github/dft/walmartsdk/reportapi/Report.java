package io.github.dft.walmartsdk.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {

    public Integer page;
    public Integer totalCount;
    public Integer limit;
    public String nextCursor;
    public List<ReportRequest> requests;
}
