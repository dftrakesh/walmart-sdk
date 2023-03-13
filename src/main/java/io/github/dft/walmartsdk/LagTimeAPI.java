package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.lagtimeapi.LagTime;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class LagTimeAPI extends WalmartSDK {

    private static final String QUESTION_MARK_CHARACTER = "?";

    public LagTimeAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public LagTime getLagTimeInventory(HashMap<String, String> params) {

        URI uri = baseurl("lagtime".concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<LagTime> handler = new JsonBodyHandler<>(LagTime.class);
        return getRequestWrapped(request, handler);
    }
}
