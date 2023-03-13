package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.ordersapi.Order;
import io.github.dft.walmartsdk.model.ordersapi.OrderWrapper;
import io.github.dft.walmartsdk.model.ordersapi.OrdersWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class OrdersAPI extends WalmartSDK {

    private static final String ORDERS = "orders";
    private static final String SLASH_CHARACTER = "/";

    public OrdersAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public List<Order> getAllOrders() {
        URI uri = baseurl(ORDERS);
        String nextCursor = null;
        List<Order> orderList = new ArrayList<>();

        do {
            if (nextCursor != null) {
                uri = baseurl(ORDERS.concat(nextCursor));
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
    public OrderWrapper getAnOrder(String purchaseOrderId) {

        URI uri = baseurl(ORDERS.concat(SLASH_CHARACTER)
                .concat(purchaseOrderId));
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
}
