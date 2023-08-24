package io.github.dft.walmartsdk.reportapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

    public List<RowFilter> rowFilters;
    public List<String> excludeColumns;
}
