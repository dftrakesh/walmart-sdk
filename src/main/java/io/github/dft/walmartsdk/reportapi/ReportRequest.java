package io.github.dft.walmartsdk.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
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
