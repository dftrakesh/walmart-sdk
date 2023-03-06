package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.lagtimeapi.LagTime;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.walmartsdk.constantcode.ConstantCodes.*;

public class LagTimeAPI extends WalmartSDK {

    public LagTimeAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public LagTime getLagTimeInventory(HashMap<String, String> params) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat("lagtime")
                .concat(QUESTION_MARK_CHARACTER));

        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, LagTime.class);
    }
}
