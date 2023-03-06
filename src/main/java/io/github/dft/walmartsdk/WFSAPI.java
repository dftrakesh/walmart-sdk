package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.wfsapi.CarrierShipment;
import io.github.dft.walmartsdk.model.wfsapi.WFSShipment;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;
import java.util.HashMap;

import static io.github.dft.walmartsdk.constantcode.ConstantCodes.*;

public class WFSAPI extends WalmartSDK {

    public WFSAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public WFSShipment getShipments(HashMap<String, String> params) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat("fulfillment")
                .concat("/inbound-shipments")
                .concat(QUESTION_MARK_CHARACTER));

        addParameters(uriBuilder, params);

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, WFSShipment.class);
    }

    @SneakyThrows
    public CarrierShipment getCarrierRateQuote(String shipmentId, String mode) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat("fulfillment")
                .concat("/carrier-rate-quotes")
                .concat(SLASH_CHARACTER)
                .concat(shipmentId)
                .concat("&")
                .concat(mode));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, CarrierShipment.class);
    }
}
