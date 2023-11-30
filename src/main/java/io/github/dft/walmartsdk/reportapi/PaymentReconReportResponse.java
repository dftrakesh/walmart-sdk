package io.github.dft.walmartsdk.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentReconReportResponse {

    private List<PaymentReportDetails> reportData;
    private Integer nextOffset;
    private Integer totalRecords;
    private String description;
}
