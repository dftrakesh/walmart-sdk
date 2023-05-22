package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.model.returnsapi.ReturnWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ReturnsAPI extends WalmartSDK {

    public ReturnsAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    @SneakyThrows
    public ReturnWrapper getReturnOrder(HashMap<String, String> params) {

        URI uri = baseurl("returns");
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<ReturnWrapper> handler = new JsonBodyHandler<>(ReturnWrapper.class);
        return getRequestWrapped(request, handler);
    }
}