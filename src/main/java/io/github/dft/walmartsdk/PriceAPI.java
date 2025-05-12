package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.model.priceapi.BulkItemPriceUpdateRequestWrapper;
import io.github.dft.walmartsdk.model.priceapi.ItemPriceResponseWrapper;
import io.github.dft.walmartsdk.model.priceapi.PriceRequest;
import io.github.dft.walmartsdk.model.priceapi.PriceUpdateResponseWrapper;
import lombok.SneakyThrows;

import java.io.File;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class PriceAPI extends WalmartSDK {

    private static final String PRICE = "price";
    private static final String FEEDS = "feeds";

    public PriceAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    public ItemPriceResponseWrapper updatePrice(PriceRequest priceRequest) {
        URI uri = baseurl(PRICE);

        HttpRequest request = put(uri, priceRequest);

        HttpResponse.BodyHandler<ItemPriceResponseWrapper> handler = new JsonBodyHandler<>(ItemPriceResponseWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public PriceUpdateResponseWrapper bulkItemPriceUpdate(File jsonFile, BulkItemPriceUpdateRequestWrapper requestWrapper, HashMap<String, String> params) {

        URI uri = baseurl(FEEDS);
        uri = addParameters(uri, params);
        Files.write(jsonFile.toPath(), getString(requestWrapper).getBytes(), StandardOpenOption.CREATE);
        HttpRequest request = postMultipart(uri, jsonFile);

        HttpResponse.BodyHandler<PriceUpdateResponseWrapper> handler = new JsonBodyHandler<>(PriceUpdateResponseWrapper.class);
        return getRequestWrapped(request, handler);
    }
}