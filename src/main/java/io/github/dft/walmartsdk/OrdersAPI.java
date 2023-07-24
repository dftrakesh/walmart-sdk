package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.model.ordersapi.Order;
import io.github.dft.walmartsdk.model.shipapi.OrderShipmentRequest;
import io.github.dft.walmartsdk.model.ordersapi.OrderWrapper;
import io.github.dft.walmartsdk.model.ordersapi.OrdersWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrdersAPI extends WalmartSDK {

    private static final String ORDERS = "orders";
    private static final String SLASH_CHARACTER = "/";

    public OrdersAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    @SneakyThrows
    public List<Order> getAllOrders(HashMap<String, String> params) {
        URI uri = baseurl(ORDERS);
        uri = addParameters(uri, params);
        String nextCursor = null;
        List<Order> orderList = new ArrayList<>();

        do {
            if (nextCursor != null) {
                uri = baseurl(ORDERS.concat(nextCursor));
                uri = addParameters(uri, params);
            }
            HttpRequest request = get(uri);

            HttpResponse.BodyHandler<OrdersWrapper> handler = new JsonBodyHandler<>(OrdersWrapper.class);
            OrdersWrapper wrapper = getRequestWrapped(request, handler);
            orderList.addAll(wrapper.getList().getElements().getOrder());
            nextCursor = wrapper.getList().getMeta().getNextCursor();
        } while (nextCursor != null);

        return orderList;
    }

    @SneakyThrows
    public OrderWrapper getAnOrder(String purchaseOrderId, HashMap<String, String> params) {

        URI uri = baseurl(ORDERS.concat(SLASH_CHARACTER)
                .concat(purchaseOrderId));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<OrderWrapper> handler = new JsonBodyHandler<>(OrderWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public OrdersWrapper getAllReleasedOrders() {

        URI uri = baseurl(ORDERS.concat(SLASH_CHARACTER)
                .concat("released"));
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<OrdersWrapper> handler = new JsonBodyHandler<>(OrdersWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public OrdersWrapper shipOrderLines(String purchaseOrderId, OrderShipmentRequest orderShipmentRequest) {

        URI uri = baseurl(ORDERS.concat(SLASH_CHARACTER)
                                .concat(purchaseOrderId)
                                .concat(SLASH_CHARACTER)
                                .concat("shipping"));
        HttpRequest request = post(uri, getString(orderShipmentRequest));

        HttpResponse.BodyHandler<OrdersWrapper> handler = new JsonBodyHandler<>(OrdersWrapper.class);
        return getRequestWrapped(request, handler);
    }
}