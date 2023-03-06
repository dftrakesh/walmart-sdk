package io.github.dft.walmartsdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.authenticationapi.AccessTokenResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

import static io.github.dft.walmartsdk.constantcode.ConstantCodes.*;

@AllArgsConstructor
@Builder(toBuilder = true)
public class WalmartSDK {

    protected HttpClient client;
    protected AccessCredential accessCredential;
    private ObjectMapper objectMapper;

    @SneakyThrows
    public WalmartSDK(AccessCredential accessCredential) {
        client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
        this.accessCredential = accessCredential;
    }

    @SneakyThrows
    protected <T> T getRequestWrapped(HttpRequest request, Class<T> tClass) {

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenComposeAsync(response -> tryResend(client, request, HttpResponse.BodyHandlers.ofString(), response, 1))
                .thenApplyAsync(HttpResponse::body)
                .thenApplyAsync(responseBody -> convertBody(responseBody, tClass))
                .get();
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

            URIBuilder uriBuilder = new URIBuilder(OAUTH_BASE_END_POINT);

            HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .header(HttpHeaders.CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .build();

            AccessTokenResponse accessTokenResponse = getRequestWrapped(request, AccessTokenResponse.class);
            accessCredential.setExpiresIn(accessTokenResponse.getExpireAt());
        }
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        Gson gson = new Gson();
        return gson.fromJson(body, tClass);
    }

    @SneakyThrows
    protected void addParameters(URIBuilder uriBuilder, HashMap<String, String> params) {

        if (params == null || params.isEmpty()) return;

        for (String key : params.keySet()) {
            uriBuilder.addParameter(key, params.get(key));
        }
    }

}
