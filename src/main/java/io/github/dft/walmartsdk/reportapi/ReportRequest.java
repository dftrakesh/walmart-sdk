package io.github.dft.walmartsdk.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportRequest {

    public String requestId;
    public String requestStatus;
    public String requestSubmissionDate;
    public String reportType;
    public String reportVersion;
    public String reportSummary;
    public String reportGenerationDate;
}
