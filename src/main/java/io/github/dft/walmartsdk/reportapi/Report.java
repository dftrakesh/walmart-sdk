package io.github.dft.walmartsdk.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Report {

    public Integer page;
    public Integer totalCount;
    public Integer limit;
    public String nextCursor;
    public List<ReportRequest> requests;
}
