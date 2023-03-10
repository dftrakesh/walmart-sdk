package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.itemsapi.*;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemsAPI extends WalmartSDK {

    private static final String ITEMS = "items";
    private static final String SLASH_CHARACTER = "/";
    private static final String QUESTION_MARK_CHARACTER = "?";

    public ItemsAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public List<ItemResponse> getAllItems() {

        HashMap<String, String> params = new HashMap<>();
        String nextCursor = "*";
        params.put("limit", "200");
        params.put("offset", "0");
        params.put("nextCursor", nextCursor);

        URI uri = baseurl(ITEMS.concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        List<ItemResponse> productList = new ArrayList<>();
        HttpResponse.BodyHandler<ItemsWrapper> handler = new JsonBodyHandler<>(ItemsWrapper.class);
        while (nextCursor != null) {
            ItemsWrapper itemsWrapper = getRequestWrapped(request, handler);
            nextCursor = itemsWrapper.getNextCursor();
            productList.addAll(itemsWrapper.getItemResponse());
        }
        return productList;
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
