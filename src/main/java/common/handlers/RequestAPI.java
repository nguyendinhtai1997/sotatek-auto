package common.handlers;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.configs.ApiConfigs.APPLICATION_JSON;
import static utils.AppConstant.*;

public class RequestAPI {
    private static final List<String> listHeaderKey = Arrays.asList(AUTHORIZATION, CONTENT_TYPE, ACCEPT);

    public static Response get(String url, Map<String, Object> request) {
        Response response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .headers(getHeaders(request))
                .queryParams(getParams(request))
                .get();
        showInfoApiRequest(url, request, null, response);
        return response;
    }

    public static Response post(String url, Map<String, Object> request, Object body) {
        Response response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .headers(getHeaders(request))
                .body(body)
                .queryParams(getParams(request))
                .post();
        showInfoApiRequest(url, request, body, response);
        return response;
    }

    public static Response postMultipartFile(String url, Map<String, Object> request, String paramFile, File file, String namePath, String value) {
        return SerenityRest.given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .headers(getHeaders(request))
                .queryParams(getParams(request))
                .contentType("multipart/form-data")
                .multiPart(paramFile, file)
                .multiPart(namePath, value)
                .post();
    }

    public static Response put(String url, Map<String, Object> request, Object body) {
        Response response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .headers(getHeaders(request))
                .body(body)
                .queryParams(getParams(request))
                .put();
        showInfoApiRequest(url, request, body, response);
        return response;
    }

    public static Response delete(String url, Map<String, Object> request) {
        return SerenityRest.given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .headers(getHeaders(request))
                .queryParams(getParams(request))
                .delete();
    }

    static Map<String, Object> getParams(Map<String, Object> request) {
        Map<String, Object> params = new HashMap<>();
        if (request != null && request.size() > 0) {
            for (Map.Entry<String, Object> entry : request.entrySet()) {
                if (!listHeaderKey.contains(entry.getKey())) {
                    params.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return params;
    }

    static Map<String, Object> getHeaders(Map<String, Object> request) {
        Map<String, Object> params = new HashMap<>();
        if (request != null && request.size() > 0) {
            for (Map.Entry<String, Object> entry : request.entrySet()) {
                if (listHeaderKey.contains(entry.getKey())) {
                    params.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return params;
    }

    public static Map<String, Object> getHeaderBeDefault(String auth) {
        Map<String, Object> request = new HashMap<>();
        if (auth.contains("Bearer"))
            request.put(AUTHORIZATION, auth);
        else request.put("x-api-key", auth);
        request.put(CONTENT_TYPE, APPLICATION_JSON);
        request.put(ACCEPT, APPLICATION_JSON);
        return request;
    }


    public static Response postMultipartFile(String url, Map<String, Object> request, String paramFile, File file) {
        return SerenityRest.given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .headers(getHeaders(request))
                .queryParams(getParams(request))
                .contentType("multipart/form-data")
                .multiPart(paramFile, file)
                .post();
    }

    private static void showInfoApiRequest(String url, Map<String, Object> request, Object body, Response response) {
        System.out.println("URL:");
        System.out.println(url);
        System.out.println("REQUEST:");
        System.out.println(getParams(request));
        if (body != null) {
            System.out.println("BODY:");
            System.out.println(Common.gson.toJson(body));
        }
        System.out.println("RESPONSE:");
        System.out.println(response.asString());
    }
}
