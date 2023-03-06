package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.feedsapi.FeedItemWrapper;
import io.github.dft.walmartsdk.model.feedsapi.FeedWrapper;
import lombok.SneakyThrows;
import org.apache.http.HttpHeaders;
import org.apache.http.client.utils.URIBuilder;

import java.net.http.HttpRequest;

import static io.github.dft.walmartsdk.constantcode.ConstantCodes.*;


public class FeedsAPI extends WalmartSDK {

    public FeedsAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public FeedWrapper getAllFeedStatuses() {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat(FEEDS));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, FeedWrapper.class);
    }

    @SneakyThrows
    public FeedItemWrapper getFeedItemStatus(String feedId) {

        URIBuilder uriBuilder = new URIBuilder(API_BASE_END_POINT.concat(SLASH_CHARACTER)
                .concat(FEEDS)
                .concat(SLASH_CHARACTER)
                .concat(feedId));

        HttpRequest request = HttpRequest.newBuilder(uriBuilder.build())
                .GET()
                .header(HttpHeaders.ACCEPT, CONTENT_TYPE_VALUE)
                .headers(ACCESS_TOKEN, accessCredential.getAccessToken())
                .headers(SERVICE_NAME, SERVICE_NAME_VALUE)
                .headers(CORRELATION_ID, CORRELATION_ID_VALUE)
                .build();

        return getRequestWrapped(request, FeedItemWrapper.class);
    }

}
