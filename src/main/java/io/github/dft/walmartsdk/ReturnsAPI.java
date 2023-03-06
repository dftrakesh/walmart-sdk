package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.returnsapi.ReturnWrapper;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;

import static io.github.dft.walmartsdk.constantcode.ConstantCodes.*;

public class ReturnsAPI extends WalmartSDK {

    public ReturnsAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ReturnWrapper getReturnOrder() {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat("returns"));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, ReturnWrapper.class);
    }
}
