package requestSpecification;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class Specification {
    static final Logger logger = LogManager.getLogger("");

    public Response getResource(String resourceId) {
        Response response = given()
                .when()
                .get(resourceId.isEmpty() ? "" : "/" + resourceId)
                .then()
                .statusCode(anyOf(is(HttpStatus.SC_OK), is(HttpStatus.SC_NOT_FOUND)))
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
                .statusCode(HttpStatus.SC_OK)
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
                .statusCode(HttpStatus.SC_OK)
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
                .statusCode(HttpStatus.SC_OK)
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
