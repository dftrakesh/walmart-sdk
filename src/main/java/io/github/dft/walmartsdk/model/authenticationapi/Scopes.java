package io.github.dft.walmartsdk.model.authenticationapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scopes {

    private String reports;
    private String item;
    private String price;
    private String lagtime;
    private String feeds;
    private String returns;
    private String orders;
    private String inventory;
    private String content;
}
