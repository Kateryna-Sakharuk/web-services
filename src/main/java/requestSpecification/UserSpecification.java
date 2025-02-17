package requestSpecification;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class UserSpecification {
    static final Logger logger = LogManager.getLogger("");

    public Response getUser(String userId) {
        Response response = given()
                .when()
                .get(userId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        logger.info("Response: " + response.getBody().asString());
        logger.info("Response Status Code: " + response.getStatusCode());

        return response;
    }

    public Response postUser(Object user) {
        Response response = given()
                .when()
                .body(user)
                .post()
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();
        logger.info("Response: " + response.getBody().asString());
        logger.info("Response Status Code: " + response.getStatusCode());

        return response;
    }

    public Response putUser(Object user) {
        Response response = given()
                .when()
                .body(user)
                .put("/users/11")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        logger.info("Response Status Code: " + response.getStatusCode());
        return response;
    }

    public Response deleteUser(String userId) {
        return given()
                .when()
                .delete(userId)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }


}
