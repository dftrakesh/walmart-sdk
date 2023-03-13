package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.AccessCredential;
import io.github.dft.walmartsdk.model.feedsapi.FeedItemWrapper;
import io.github.dft.walmartsdk.model.feedsapi.FeedWrapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class FeedsAPI extends WalmartSDK {

    private static final String FEEDS = "feeds";
    private static final String SLASH_CHARACTER = "/";

    public FeedsAPI(AccessCredential accessCredential) {
        super(accessCredential);
    }

    @SneakyThrows
    public FeedWrapper getAllFeedStatuses(HashMap<String, String> params) {

        URI uri = baseurl(FEEDS);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<FeedWrapper> handler = new JsonBodyHandler<>(FeedWrapper.class);
        return getRequestWrapped(request, handler);
    }

    @SneakyThrows
    public FeedItemWrapper getFeedItemStatus(String feedId, HashMap<String, String> params) {

        URI uri = baseurl(FEEDS.concat(SLASH_CHARACTER).concat(feedId));
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<FeedItemWrapper> handler = new JsonBodyHandler<>(FeedItemWrapper.class);
        return getRequestWrapped(request, handler);
    }
}
