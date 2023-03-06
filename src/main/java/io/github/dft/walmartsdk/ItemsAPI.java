package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.constantcode.ConstantCodes;
import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.itemsapi.ItemWrapper;
import io.github.dft.walmartsdk.model.itemsapi.ItemsWrapper;
import io.github.dft.walmartsdk.model.itemsapi.SearchWrapper;
import io.github.dft.walmartsdk.model.itemsapi.TaxonomyWrapper;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.walmartsdk.constantcode.ConstantCodes.*;

public class ItemsAPI extends WalmartSDK {

    public ItemsAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public ItemsWrapper getAllItems(HashMap<String, String> params) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(ConstantCodes.SLASH_CHARACTER)
                .concat(ITEMS)
                .concat(QUESTION_MARK_CHARACTER));
        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, ItemsWrapper.class);
    }

    @SneakyThrows
    public ItemWrapper getAnItem(String itemId, HashMap<String, String> params) {

        URIBuilder uriBuilder = new URIBuilder(ConstantCodes.API_BASE_END_POINT.concat(ConstantCodes.SLASH_CHARACTER)
                .concat(ConstantCodes.ITEMS)
                .concat(ConstantCodes.SLASH_CHARACTER)
                .concat(itemId)
                .concat(QUESTION_MARK_CHARACTER));

        addParameters(uriBuilder, params);


        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, ConstantCodes.CONTENT_TYPE_VALUE)
                .headers(ConstantCodes.ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(ConstantCodes.SERVICE_NAME, ConstantCodes.SERVICE_NAME_VALUE)
                .headers(ConstantCodes.CORRELATION_ID, ConstantCodes.CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, ItemWrapper.class);
    }

    @SneakyThrows
    public SearchWrapper getItemSearch(HashMap<String, String> params) {

        URIBuilder uriBuilder = new URIBuilder(ConstantCodes.API_BASE_END_POINT.concat(ConstantCodes.SLASH_CHARACTER)
                .concat(ConstantCodes.ITEMS)
                .concat(ConstantCodes.SLASH_CHARACTER)
                .concat(ConstantCodes.WALMART)
                .concat(ConstantCodes.SLASH_CHARACTER)
                .concat(ConstantCodes.SEARCH)
                .concat(ConstantCodes.QUESTION_MARK_CHARACTER));

        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, ConstantCodes.CONTENT_TYPE_VALUE)
                .headers(ConstantCodes.ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(ConstantCodes.SERVICE_NAME, ConstantCodes.SERVICE_NAME_VALUE)
                .headers(ConstantCodes.CORRELATION_ID, ConstantCodes.CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, SearchWrapper.class);
    }

    @SneakyThrows
    public TaxonomyWrapper getTaxonomy() {

        URIBuilder uriBuilder = new URIBuilder(ConstantCodes.API_BASE_END_POINT.concat(ConstantCodes.SLASH_CHARACTER)
                .concat(ConstantCodes.ITEMS)
                .concat(ConstantCodes.SLASH_CHARACTER)
                .concat("taxonomy"));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, ConstantCodes.CONTENT_TYPE_VALUE)
                .headers(ConstantCodes.ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(ConstantCodes.SERVICE_NAME, ConstantCodes.SERVICE_NAME_VALUE)
                .headers(ConstantCodes.CORRELATION_ID, ConstantCodes.CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, TaxonomyWrapper.class);
    }
}
