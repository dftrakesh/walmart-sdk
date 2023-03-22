package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.authenticationapi.AccessTokenResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@Builder(builderMethodName = "newBuilder",toBuilder = true)
public class WalmartSDK {

    protected HttpClient client;
    protected AccessCredential accessCredential;

    private static final int MAX_ATTEMPTS = 50;
    private static final int TIME_OUT_DURATION = 3000;
    private static final int TOO_MANY_REQUEST_EXCEPTION_CODE = 429;

    private static final String ACCEPT = "Accept";
    private static final String SLASH_CHARACTER = "/";
    private static final String SERVICE_NAME = "WM_SVC.NAME";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCESS_TOKEN = "WM_SEC.ACCESS_TOKEN";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String CORRELATION_ID = "WM_QOS.CORRELATION_ID";
    private static final String SERVICE_NAME_VALUE = "Walmart Service Name";
    private static final String CORRELATION_ID_VALUE = "b3261d2d-028a-4ef7-8602-633c23200af5";
    private static final String API_BASE_END_POINT = "https://marketplace.walmartapis.com/v3";
    private static final String OAUTH_BASE_END_POINT = "https://marketplace.walmartapis.com/v3/token";

    @SneakyThrows
    public WalmartSDK(AccessCredential accessCredential) {
        client = HttpClient.newHttpClient();
        this.accessCredential = accessCredential;
    }

    public ItemsAPI getItemsAPI(){
        return new ItemsAPI(accessCredential);
    }

    public OrdersAPI getOrdersAPI(){
        return new OrdersAPI(accessCredential);
    }

    @SneakyThrows
    public <T> T getRequestWrapped(HttpRequest request, HttpResponse.BodyHandler<T> handler) {
        return client
                .sendAsync(request, handler)
                .thenComposeAsync(response -> tryResend(client, request, handler, response, 1))
                .get()
                .body();
    }

    @SneakyThrows
    protected <T> CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
                                                               HttpRequest request,
                                                               HttpResponse.BodyHandler<T> handler,
                                                               HttpResponse<T> resp, int count) {

        if (resp.statusCode() == TOO_MANY_REQUEST_EXCEPTION_CODE && count < MAX_ATTEMPTS) {
            Thread.sleep(TIME_OUT_DURATION);
            return client.sendAsync(request, handler)
                    .thenComposeAsync(response -> tryResend(client, request, handler, response, count + 1));
        }
        return CompletableFuture.completedFuture(resp);
    }

    @SneakyThrows
    protected void refreshAccessToken() {

        if (accessCredential.getAccessToken() == null || accessCredential.getExpiresIn() == null) {

            URI uri = new URI(OAUTH_BASE_END_POINT);
            HttpRequest request = HttpRequest.newBuilder(uri)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .build();
            HttpResponse.BodyHandler<AccessTokenResponse> handler = new JsonBodyHandler<>(AccessTokenResponse.class);
            AccessTokenResponse accessTokenResponse = getRequestWrapped(request, handler);
            accessCredential.setExpiresIn(accessTokenResponse.getExpireAt());
        }
    }

    @SneakyThrows
    protected URI addParameters(URI uri, HashMap<String, String> params) {

        String query = uri.getQuery();
        StringBuilder builder = new StringBuilder();
        if (query != null)
            builder.append(query);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String keyValueParam = entry.getKey() + "=" + entry.getValue();
            if (!builder.toString().isEmpty())
                builder.append("&");
            builder.append(keyValueParam);
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), builder.toString(), uri.getFragment());
    }

    protected URI baseurl(String path) {
        return URI.create(API_BASE_END_POINT +
                SLASH_CHARACTER +
                path);
    }

    @SneakyThrows
    protected HttpRequest get(URI uri) {
        return HttpRequest.newBuilder(uri)
                .header(ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .GET()
                .build();
    }
}
