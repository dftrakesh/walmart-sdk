package io.github.dft.walmartsdk.model.authenticationapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class AccessTokenResponse {
    private String expireAt;
    private String issuedAt;
    private Boolean isValid;
    private Scopes scopes;
}
