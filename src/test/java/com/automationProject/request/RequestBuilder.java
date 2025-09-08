package com.automationProject.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;

import java.util.Map;

public class RequestBuilder {

    public static Response getRequest(String baseUrl, String path) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        return  requestSpecification.get(path);
    }

    public static Response getRequest(String baseUrl, String path, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());

        if (apiKey != null) {
            requestSpecification.header("special-key", apiKey);
        }

        return  requestSpecification.get(path);
    }

    public static Response getRequest(String baseUrl, String path, Object body, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(body);

        if (apiKey != null) {
            requestSpecification.header("special-key", apiKey);
        }

        return  requestSpecification.get(path);
    }

    public static Response getRequestWithQueryParams(String baseUrl, String path, Map<String, String> queryParams, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .queryParams(queryParams);

        if (apiKey != null) {
            requestSpecification.header("special-key", apiKey);
        }

        return requestSpecification.get();
    }

    public static Response postRequest(String baseUrl, String path, Object body, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(body);

        if (apiKey != null) {
            requestSpecification.header("special-key", apiKey);
        }

        return  requestSpecification.post(path);
    }

    public static Response deleteRequest(String baseUrl, String path, Integer id, String apiKey) {
        RequestSpecification requestSpecification = RestAssured.given()
                .baseUri(baseUrl)
                .basePath(path)
                .header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType())
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .pathParams("id", id);

        if (apiKey != null) {
            requestSpecification.header("special-key", apiKey);
        }

        return  requestSpecification.delete("/{id}");
    }
}
