package core;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestSpecification {
    private final io.restassured.specification.RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri("https://jsonplaceholder.typicode.com")
            .setBasePath("/users")
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

    public Response getUser(String userId) {
        return given(requestSpecification)
                .when()
                .get(userId);
    }

    public Response postUser(Object user){
        return given(requestSpecification)
                .when()
                .body(user)
                .post();
    }
    public Response putUser(Object user) {
        return given(requestSpecification)
                .when()
                .body(user)
                .put();
    }
    public Response deleteUser(String userId) {
        return given(requestSpecification)
                .when()
                .delete(userId);
    }


}
