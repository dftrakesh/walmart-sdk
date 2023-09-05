package io.github.dft.walmartsdk;

import io.github.dft.walmartsdk.handler.JsonBodyHandler;
import io.github.dft.walmartsdk.model.authenticationapi.WalmartCredentials;
import io.github.dft.walmartsdk.reportapi.Report;
import io.github.dft.walmartsdk.reportapi.ReportRequest;
import io.github.dft.walmartsdk.reportapi.ReportUrl;
import io.github.dft.walmartsdk.reportapi.RequestWrapper;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class ReportAPI extends WalmartSDK {

    private static final String REPORTS = "reports";
    private static final String REPORTSREQUESTS = "reportRequests";
    private static final String DOWNLOADREPORT = "downloadReport";
    private static final String SLASH_CHARACTER = "/";

    public ReportAPI(WalmartCredentials walmartCredentials) {
        super(walmartCredentials);
    }

    public Report getAllReport(HashMap<String, String> params) {

        URI uri = baseurl(REPORTS + SLASH_CHARACTER + REPORTSREQUESTS);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<Report> handler = new JsonBodyHandler<>(Report.class);
        return getRequestWrapped(request, handler);
    }

    public RequestWrapper createReportRequest(HashMap<String, String> params) {

        URI uri = baseurl(REPORTS + SLASH_CHARACTER + REPORTSREQUESTS);
        uri = addParameters(uri, params);
        HttpRequest request = post(uri);

        HttpResponse.BodyHandler<RequestWrapper> handler = new JsonBodyHandler<>(RequestWrapper.class);
        return getRequestWrapped(request, handler);
    }

    public ReportRequest getRequestStatus(String requestId) {

        URI uri = baseurl(REPORTS + SLASH_CHARACTER + REPORTSREQUESTS + SLASH_CHARACTER + requestId);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<ReportRequest> handler = new JsonBodyHandler<>(ReportRequest.class);
        return getRequestWrapped(request, handler);
    }

    public ReportUrl getReportURL(HashMap<String, String> params) {

        URI uri = baseurl(REPORTS + SLASH_CHARACTER + DOWNLOADREPORT);
        uri = addParameters(uri, params);
        HttpRequest request = get(uri);

        HttpResponse.BodyHandler<ReportUrl> handler = new JsonBodyHandler<>(ReportUrl.class);
        return getRequestWrapped(request, handler);
    }
}