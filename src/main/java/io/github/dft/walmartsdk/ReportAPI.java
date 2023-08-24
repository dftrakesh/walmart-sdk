package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.reportapi.Report;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ReportAPI extends WalmartSDK {

    private static final String REPORTS = "reports";
    private static final String REPORTSREQUEST = "reportRequests";
    private static final String SLASH_CHARACTER = "/";

    public ReportAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    public Report getAllReport(HashMap<String, String> params) {

        URI uri = baseurl(REPORTS + SLASH_CHARACTER + REPORTSREQUEST);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<Report> handler = new JsonBodyHandler<>(Report.class);
        return getRequestWrapped(request, handler);
    }
}