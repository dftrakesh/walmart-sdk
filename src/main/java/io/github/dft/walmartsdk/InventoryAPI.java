package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.model.inventoryapi.InventoryWrapper;
import io.github.dft.walmartsdk.model.inventoryapi.MultiItemInventory;
import io.github.dft.walmartsdk.model.inventoryapi.SingleItemInventory;
import io.github.dft.walmartsdk.model.inventoryapi.WFSInventory;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.util.HashMap;

public class InventoryAPI extends WalmartSDK {

    private static final String INVENTORY = "inventory";
    private static final String SLASH_CHARACTER = "/";
    private static final String INVENTORIES = "inventories";
    private static final String QUESTION_MARK_CHARACTER = "?";
    private static final String FEEDS = "feeds";

    public InventoryAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    @SneakyThrows
    public InventoryWrapper getInventory(HashMap<String, String> params) {

        URI uri = baseurl(INVENTORY.concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<InventoryWrapper> handler = new JsonBodyHandler<>(InventoryWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public SingleItemInventory getSingleItemInventoryByShipNode(HashMap<String, String> params, String sku) {

        URI uri = baseurl(INVENTORIES.concat(SLASH_CHARACTER)
                .concat(sku)
                .concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<SingleItemInventory> handler = new JsonBodyHandler<>(SingleItemInventory.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public MultiItemInventory getMultipleItemInventoryForAllShipNodes(HashMap<String, String> params) {

        URI uri = baseurl(INVENTORIES);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<MultiItemInventory> handler = new JsonBodyHandler<>(MultiItemInventory.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public WFSInventory getWFSInventory(HashMap<String, String> params) {

        URI uri = baseurl("fulfillment".concat(SLASH_CHARACTER)
                .concat(INVENTORY)
                .concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<WFSInventory> handler = new JsonBodyHandler<>(WFSInventory.class);
        return getRequestWrapped(request, handler);
    }

    public InventoryWrapper updateInventory(HashMap<String, String> params, InventoryWrapper inventoryWrapper) {

        URI uri = baseurl(INVENTORY);
        uri = addParameters(uri, params);
        HttpRequest request = put(uri, getString(inventoryWrapper));

        HttpResponse.BodyHandler<InventoryWrapper> handler = new JsonBodyHandler<>(InventoryWrapper.class);
        return getRequestWrapped(request, handler);
    }

    public InventoryWrapper bulkItemInventoryUpdate(HashMap<String, String> params, String jsonFilePath){

        URI uri = baseurl(FEEDS);
        uri = addParameters(uri, params);
        File jsonFile = new File(jsonFilePath);
        HttpRequest request = postMultipart(uri, jsonFile);

        HttpResponse.BodyHandler<InventoryWrapper> handler = new JsonBodyHandler<>(InventoryWrapper.class);
        return getRequestWrapped(request, handler);
    }
}