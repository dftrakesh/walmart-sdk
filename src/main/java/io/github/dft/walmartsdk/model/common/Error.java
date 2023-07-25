package io.github.dft.walmartsdk.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    private String code;
    private String field;
    private String description;
    private String info;
    private String severity;
    private String category;
    private List<Object> causes;
}