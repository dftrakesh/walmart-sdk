package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.inventoryapi.InventoryWrapper;
import io.github.dft.walmartsdk.model.inventoryapi.MultiItemInventory;
import io.github.dft.walmartsdk.model.inventoryapi.SingleItemInventory;
import io.github.dft.walmartsdk.model.inventoryapi.WFSInventory;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.walmartsdk.constantcode.ConstantCodes.*;

public class InventoryAPI extends WalmartSDK {

    public InventoryAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public InventoryWrapper getInventory(HashMap<String, String> params) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat(INVENTORY)
                .concat(QUESTION_MARK_CHARACTER));

        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, InventoryWrapper.class);
    }

    @SneakyThrows
    public SingleItemInventory getSingleItemInventoryByShipNode(HashMap<String, String> params, String sku) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat(INVENTORIES)
                .concat(SLASH_CHARACTER)
                .concat(sku)
                .concat(QUESTION_MARK_CHARACTER));
        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, SingleItemInventory.class);
    }

    @SneakyThrows
    public MultiItemInventory getMultipleItemInventoryForAllShipNodes() {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat(INVENTORIES));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, MultiItemInventory.class);
    }

    @SneakyThrows
    public WFSInventory getWFSInventory(HashMap<String, String> params) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat("fulfillment")
                .concat(SLASH_CHARACTER)
                .concat(INVENTORY)
                .concat(QUESTION_MARK_CHARACTER));

        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, WFSInventory.class);
    }

}
