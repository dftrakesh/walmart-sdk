package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.model.wfsapi.CarrierShipment;
import io.github.dft.walmartsdk.model.wfsapi.WFSShipment;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class WFSAPI extends WalmartSDK {

    private static final String SLASH_CHARACTER = "/";
    private static final String QUESTION_MARK_CHARACTER = "?";

    public WFSAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    @SneakyThrows
    public WFSShipment getShipments(HashMap<String, String> params) {

        URI uri = baseurl("fulfillment".concat("/inbound-shipments")
                .concat(QUESTION_MARK_CHARACTER));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<WFSShipment> handler = new JsonBodyHandler<>(WFSShipment.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public CarrierShipment getCarrierRateQuote(String shipmentId, String mode) {

        URI uri = baseurl("fulfillment".concat("/carrier-rate-quotes")
                .concat(SLASH_CHARACTER)
                .concat(shipmentId)
                .concat("&")
                .concat(mode));
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<CarrierShipment> handler = new JsonBodyHandler<>(CarrierShipment.class);
        return getRequestWrapped(request, handler);
    }
}