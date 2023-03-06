package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.ordersapi.Order;
import io.github.dft.walmartsdk.model.ordersapi.OrderWrapper;
import io.github.dft.walmartsdk.model.ordersapi.OrdersWrapper;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import static io.github.dft.walmartsdk.constantcode.ConstantCodes.*;

public class OrdersAPI extends WalmartSDK {

    public OrdersAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public List<Order> getAllOrders() {
        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat(ORDERS));
        String nextCursor = null;

        List<Order> orderList = new ArrayList<>();

        do {
            if (nextCursor != null) {
                uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                        .concat(ORDERS)
                        .concat(nextCursor));
            }
            HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                    .GET()
                    .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                    .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                    .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                    .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                    .build();

            OrdersWrapper wrapper = getRequestWrapped(request, OrdersWrapper.class);
            orderList.addAll(wrapper.getList().getElements().getOrder());
            nextCursor = wrapper.getList().getMeta().getNextCursor();
        } while (nextCursor != null);

        return orderList;
    }

    @SneakyThrows
    public OrderWrapper getAnOrder(String purchaseOrderId) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat(ORDERS)
                .concat(SLASH_CHARACTER)
                .concat(purchaseOrderId));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, OrderWrapper.class);
    }

    @SneakyThrows
    public OrdersWrapper getAllReleasedOrders() {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat(ORDERS)
                .concat(SLASH_CHARACTER)
                .concat("released"));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, OrdersWrapper.class);
    }

}
