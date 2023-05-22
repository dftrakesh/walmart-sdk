package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.model.priceapi.ItemPriceResponseWrapper;
import io.github.dft.walmartsdk.model.priceapi.PriceRequest;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PriceAPI extends WalmartSDK {

    private static final String PRICE = "price";

    public PriceAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    public ItemPriceResponseWrapper updatePrice(PriceRequest priceRequest) {
        URI uri = baseurl(PRICE);

        HttpRequest request = put(uri, priceRequest);

        HttpResponse.BodyHandler<ItemPriceResponseWrapper> handler = new JsonBodyHandler<>(ItemPriceResponseWrapper.class);
        return getRequestWrapped(request, handler);
    }
}