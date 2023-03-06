package io.github.dft.walmartsdk.constantcode;

public interface ConstantCodes {
    String SLASH_CHARACTER = "/";
    String QUESTION_MARK_CHARACTER = "?";
    String CLIENT_ID = "client_id";
    String PATCH_REQUEST = "PATCH";
    String GRANT_TYPE = "grant_type";
    String TOKEN_NAME = "Bearer Token";
    String ACCESS_TOKEN = "WM_SEC.ACCESS_TOKEN";
    String CHANNEL_TYPE = "WM_CONSUMER.CHANNEL.TYPE";
    String CORRELATION_ID = "WM_QOS.CORRELATION_ID";
    String CORRELATION_ID_VALUE = "b3261d2d-028a-4ef7-8602-633c23200af5";
    String SERVICE_NAME = "WM_SVC.NAME";
    String SERVICE_NAME_VALUE = "Walmart Service Name";
    String CLIENT_SECRET = "client_secret";
    String AUTHORIZATION_HEADER = "Authorization";
    String CONTENT_TYPE_VALUE = "application/json";
    String REFRESH_TOKEN = "refresh_token";
    String WALMART = "walmart";
    String SEARCH = "search";
    String COUNT = "count";
    String ITEMS = "items";
    String ORDERS = "orders";
    String FEEDS = "feeds";
    String INVENTORY = "inventory";
    String INVENTORIES = "inventories";

    String API_BASE_END_POINT = "https://marketplace.walmartapis.com/v3";
    String OAUTH_BASE_END_POINT = "https://marketplace.walmartapis.com/v3/token";


    int MAX_ATTEMPTS = 50;
    int TIME_OUT_DURATION = 3000;
    int TOO_MANY_REQUEST_EXCEPTION_CODE = 429;
}