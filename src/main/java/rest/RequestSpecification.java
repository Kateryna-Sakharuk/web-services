package rest;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class RequestSpecification {
    private static final Logger logger = LogManager.getLogger(RequestSpecification.class);

    private String BASE_BOOKS_PATH = "%s/books";
    private String BASE_BOOKS_ID_PATH = "%s/books/%s";
    private String POST_BOOKS = "%s/books/save";

    public Response getResource(String resourceId) {
        Response response = given()
                .when()
                .get(resourceId.isEmpty() ? "" : "/" + resourceId)
                .then()
                .log().all()
                .extract()
                .response();
        logResponse(response);
        return response;
    }

    public Response postResource(Object resource) {
        Response response = given()
                .when()
                .body(resource)
                .post()
                .then()
                .log().all()
                .extract()
                .response();
        logResponse(response);
        return response;
    }

    public Response putResource(Object resource) {
        Response response = given()
                .when()
                .body(resource)
                .put()
                .then()
                .log().all()
                .extract()
                .response();
        logResponse(response);
        return response;
    }

    public Response deleteResource(String resourceId) {
        Response response = given()
                .when()
                .delete(resourceId)
                .then()
                .log().all()
                .extract()
                .response();
        logResponse(response);
        return response;

    }

    private void logResponse(Response response) {
        logger.info("Response Status Code: {}", response.getStatusCode());
        logger.info("Response Body: {}", response.getBody().asPrettyString());
    }
}
