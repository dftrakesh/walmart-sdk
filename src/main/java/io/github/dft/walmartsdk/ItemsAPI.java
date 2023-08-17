package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.model.itemsapi.ItemWrapper;
import io.github.dft.walmartsdk.model.itemsapi.ItemsWrapper;
import io.github.dft.walmartsdk.model.itemsapi.SearchWrapper;
import io.github.dft.walmartsdk.model.itemsapi.TaxonomyWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ItemsAPI extends WalmartSDK {

    private static final String ITEMS = "items";
    private static final String SLASH_CHARACTER = "/";
    private static final String QUESTION_MARK_CHARACTER = "?";

    public ItemsAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    public ItemsWrapper getAllItems(HashMap<String, String> params) {

        URI uri = baseurl(ITEMS);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<ItemsWrapper> handler = new JsonBodyHandler<>(ItemsWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public ItemsWrapper getItems(HashMap<String, String> params) {

        URI uri = baseurl(ITEMS.concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<ItemsWrapper> handler = new JsonBodyHandler<>(ItemsWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public ItemWrapper getAnItem(String itemId, HashMap<String, String> params) {

        URI uri = baseurl(ITEMS.concat(SLASH_CHARACTER)
                .concat(itemId)
                .concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<ItemWrapper> handler = new JsonBodyHandler<>(ItemWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public SearchWrapper getItemSearch(HashMap<String, String> params) {

        URI uri = baseurl(ITEMS.concat(SLASH_CHARACTER)
                .concat("walmart")
                .concat(SLASH_CHARACTER)
                .concat("search")
                .concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<SearchWrapper> handler = new JsonBodyHandler<>(SearchWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public TaxonomyWrapper getTaxonomy() {

        URI uri = baseurl(ITEMS.concat(SLASH_CHARACTER)
                .concat("taxonomy"));
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<TaxonomyWrapper> handler = new JsonBodyHandler<>(TaxonomyWrapper.class);
        return getRequestWrapped(request, handler);
    }
}